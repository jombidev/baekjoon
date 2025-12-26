import java.util.LinkedList
import java.util.PriorityQueue

fun main() {
    val (n, e) = readln().split(' ').map { it.toInt() }

    val nodes = HashMap<Int, MutableList<Pair<Int, Int>>>()

    repeat(e) {
        val (src, dst, p) = readln().split(' ').map { it.toInt() - 1 }

        val srcMap = nodes[src] ?: mutableListOf()
        srcMap.add(dst to p + 1)
        nodes[src] = srcMap
        val dstMap = nodes[dst] ?: mutableListOf()
        dstMap.add(src to p + 1)
        nodes[dst] = dstMap
    }


    val (src, dst) = readln().split(' ').map { it.toInt() - 1 }

    fun dijkstra(sn: Int): IntArray {
        val dijkstra = IntArray(n) { Int.MAX_VALUE }
        val v = BooleanArray(n)
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        dijkstra[sn] = 0

        nodes[sn]?.forEach {
            pq.add(it.first to it.second)
        }

        while (pq.isNotEmpty()) {
            val (d, p) = pq.remove()
            if (v[d]) continue
            v[d] = true
            if (dijkstra[d] > p)
                dijkstra[d] = p

            nodes[d]?.forEach {
                pq.add(it.first to it.second + p)
            }
        }

        return dijkstra
    }

    val fd = dijkstra(0)
    val sd = dijkstra(src)
    val td = dijkstra(dst)

    val available = LinkedList<Int>()

    if (fd[src] != Int.MAX_VALUE) {
        if (sd[dst] != Int.MAX_VALUE) {
            if (td[n - 1] != Int.MAX_VALUE) {
                available.add(fd[src] + sd[dst] + td[n - 1])
            }
        }
    }

    if (fd[dst] != Int.MAX_VALUE) {
        if (td[src] != Int.MAX_VALUE) {
            if (sd[n - 1] != Int.MAX_VALUE) {
                available.add(fd[dst] + td[src] + sd[n - 1])
            }
        }
    }

    print(available.minOrNull() ?: -1)
}
