fun main() {
    class P(val p: Int, val t: Int)
    val (n, k) = readln().split(' ').map { it.toInt() }
    val ll = java.util.LinkedList<P>()
    val v = BooleanArray(200000)
    ll.add(P(n, 0))

    while (ll.isNotEmpty()) {
        val l = ll.removeFirst()
        val pos = l.p
        val time = l.t

        if (v[pos]) continue
        v[pos] = true

        if (pos == k)
            return print(time)

        if (pos > 0)
            ll.addLast(P(pos - 1, time + 1))
        if (pos <= k) {
            ll.addLast(P(pos + 1, time + 1))
            if (pos > 0)
                ll.addLast(P(pos * 2, time + 1))
        }
    }
}
