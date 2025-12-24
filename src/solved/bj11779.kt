import java.util.LinkedList
import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()

    val nodes = HashMap<Int, MutableList<Pair<Int, Int>>>()
    val dijkstra = Array(n) { Int.MAX_VALUE to -1 }
    val v = BooleanArray(n)

    repeat(m) {
        val (src, dst, p) = readln().split(' ').map { it.toInt() - 1 }

        val srcMap = nodes[src] ?: mutableListOf()
        srcMap.add(dst to p + 1)
        nodes[src] = srcMap
    }

    val pq = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.second })

    val (src, dst) = readln().split(' ').map { it.toInt() - 1 }
    dijkstra[src] = 0 to -1

    nodes[src]?.forEach {
        pq.add(Triple(it.first, it.second, -1))
    }

    while (pq.isNotEmpty()) {
        val (d, p, parent) = pq.remove()
        if (v[d]) continue
        v[d] = true
        if (dijkstra[d].first > p) {
            dijkstra[d] = p to parent
        }

        nodes[d]?.forEach {
            pq.add(Triple(it.first, it.second + p, d))
        }
    }

    var prev = dst
    val path = LinkedList<Int>()
    do {
        path.add(prev + 1)
        val dijk = dijkstra[prev]
        prev = dijk.second
    } while (prev != -1)
    path.add(src + 1)

    println(dijkstra[dst].first)
    println(path.size)
    print(path.reversed().joinToString(" "))
}
