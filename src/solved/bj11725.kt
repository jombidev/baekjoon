fun main() = System.`in`.bufferedReader().use {
    val bw = System.out.bufferedWriter()
    fun r() = it.readLine().trim()
    val n = r().toInt()

    val nodes = Array(n + 1) { LinkedHashSet<Int>() }

    repeat(n - 1) {
        val (c, p) = r().split(' ').map { it.toInt() }
        nodes[c].add(p)
        nodes[p].add(c)
    }

    val v = BooleanArray(nodes.size)
    val p = IntArray(n + 1) { -1 }
    val ll = java.util.LinkedList<Int>()
    ll.add(1)

    while (ll.isNotEmpty()) {
        val m = ll.removeFirst()

        if (v[m])
            continue
        v[m] = true

        for (i in nodes[m]) {
            if (p[i] != -1)
                continue
            p[i] = m
            ll.add(i)
        }
    }


    for (i in 2..n) {
        bw.write("${p[i]}\n")
    }
    bw.flush()
    bw.close()
}
