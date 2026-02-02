import java.util.PriorityQueue

fun main() = System.`in`.bufferedReader().use {
    fun r() = it.readLine()
    val (n, m) = r().split(' ').map { it.toInt() }
    val edges = Array(n) { ArrayList<Int>() }
    val ic = IntArray(n) { 0 }

    repeat(m) {
        val (s, e) = r().split(' ').map { it.toInt() - 1 }
        edges[s].add(e)
        ic[e]++
    }

    val q = PriorityQueue<Int>()
    val s = ArrayDeque<Int>()

    for (i in ic.indices) if (ic[i] == 0) q.add(i)

    while (q.isNotEmpty()) {
        val v = q.remove()
        s.add(v)
        for (i in edges[v]) {
            if (--ic[i] == 0) {
                q.add(i)
            }
        }
    }

    print(s.joinToString(" ") { "${it + 1}" })
}
