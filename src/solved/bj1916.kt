import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()

    val nodes = HashMap<Int, MutableList<Pair<Int, Int>>>()
    val dijkstra = Array(n) { Int.MAX_VALUE }
    val v = BooleanArray(n)

    repeat(m) {
        val (src, dst, p) = readln().split(' ').map { it.toInt() - 1 }

        val srcMap = nodes[src] ?: mutableListOf()
        srcMap.add(dst to p + 1)
        nodes[src] = srcMap
    }

    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

    val (src, dst) = readln().split(' ').map { it.toInt() - 1 }
    dijkstra[src] = 0

    nodes[src]?.forEach {
        pq.add(it)
    }

    while (pq.isNotEmpty()) {
        val (d, p) = pq.remove()
        if (v[d]) continue
        v[d] = true
        dijkstra[d] = minOf(dijkstra[d], p)

        nodes[d]?.forEach {
            pq.add(it.first to it.second + p)
        }
    }

    print(dijkstra[dst])
}
