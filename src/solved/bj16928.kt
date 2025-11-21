fun main() {
    val (l, s) = readln().split(' ').map { it.toInt() }

    val ls = Array(l) { readln().split(' ').map { it.toInt() } }.associate { it[0] to it[1] }
    val ss = Array(s) { readln().split(' ').map { it.toInt() } }.associate { it[0] to it[1] }

    val v = Array(101) { false }

    val ll = java.util.LinkedList<Pair<Int, Int>>()
    ll.add(1 to 0)

    while (ll.isNotEmpty()) {
        val (m, dc) = ll.removeFirst()

        if (m == 100) {
            return print(dc)
        }

        if (v[m])
            continue
        v[m] = true

        val dl = ls[m]?.let {
            if (!v[it])
                ll.addFirst(it to dc)
            true
        } ?: false
        val ds = ss[m]?.let {
            if (!v[it])
                ll.addFirst(it to dc)
            true
        } ?: false

        if (!dl && !ds)
            for (i in 1..6) {
                if (m + i > 100 || v[m + i])
                    continue

                ll.add(m + i to dc + 1)
            }
    }
}
