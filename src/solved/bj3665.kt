fun main() = System.`in`.bufferedReader().use {
    fun r() = it.readLine()

    repeat(r().toInt()) {
        val n = r().toInt()
        val t = r().split(' ').map { it.toInt() - 1 }

        val nodes = Array(n) { ArrayList<Int>() }
        val ic = IntArray(n) { 0 }

        val m = r().toInt()

        for (i in 0..<n)
            for (j in n - 1 downTo i + 1)
                nodes[t[i]].add(t[j])

        repeat(m) {
            val (s, e) = r().split(' ').map { it.toInt() - 1 }

            if (nodes[e].contains(s)) {
                nodes[e].remove(s)
                nodes[s].add(e)
            } else if (nodes[s].contains(e)) {
                nodes[s].remove(e)
                nodes[e].add(s)
            }
        }

        for (edges in nodes) for (end in edges) ic[end]++

        val rs = IntArray(n)
        for (i in rs.indices) rs[ic[i]] = i + 1

        if (rs.sum() != n * (n + 1) / 2)
            return@repeat println("IMPOSSIBLE")

        println(rs.joinToString(" "))
    }
}
