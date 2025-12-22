import java.util.PriorityQueue

fun main() {
    val (v, e) = readln().split(' ').map { it.toInt() }
    val src = readln().toInt()

    val nodes = HashMap<Int, MutableList<Pair<Int, Int>>>()
    val dijkstra = Array(v + 1) { Int.MAX_VALUE }
    val vv = BooleanArray(v + 1)

    repeat(e) {
        val (src, dst, p) = readln().split(' ').map { it.toInt() }

        val srcMap = nodes[src] ?: mutableListOf()
        srcMap.add(dst to p)
        nodes[src] = srcMap
    }

    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

    dijkstra[src] = 0

    nodes[src]?.forEach {
        pq.add(it)
    }

    while (pq.isNotEmpty()) {
        val (d, p) = pq.remove()
        dijkstra[d] = minOf(dijkstra[d], p)

        if (vv[d]) continue
        vv[d] = true

        nodes[d]?.forEach {
            pq.add(it.first to it.second + p)
        }
    }

    print(dijkstra.drop(1).joinToString("\n") { if (it == Int.MAX_VALUE) "INF" else "$it" })
}
