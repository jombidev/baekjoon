import java.util.PriorityQueue

fun main() = System.`in`.bufferedReader().use {
    fun r() = it.readLine()
    repeat(r().toInt()) {
        val (n, m, t) = r().split(' ').map { it.toInt() }
        val (s, g, h) = r().split(' ').map { it.toInt() - 1 }

        val nodes = HashMap<Int, MutableList<Pair<Int, Int>>>()

        repeat(m) {
            val (src, dst, p) = r().split(' ').map { it.toInt() - 1 }

            nodes.getOrPut(src) { mutableListOf() }.add(dst to p + 1)
            nodes.getOrPut(dst) { mutableListOf() }.add(src to p + 1)
        }

        val available = Array(t) { r().toInt() - 1 }

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

        val fd = dijkstra(s)
        val sd = dijkstra(g)
        val td = dijkstra(h)

        val cases = ArrayList<Int>()

        if (fd[g] < fd[h]) {
            val base = fd[g].toLong() + sd[h]
            for (i in available) {
                if (fd[i] < base + td[i])
                    continue

                cases.add(i)
            }
        } else {
            val base = fd[h].toLong() + td[g]
            for (i in available) {
                if (fd[i] < base + sd[i])
                    continue

                cases.add(i)
            }
        }

        cases.sort()
        println(cases.joinToString(" ") { "${it + 1}" })
    }
}
