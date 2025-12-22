fun main() {
    class P(val p: Int, val t: Int)
    val (n, k) = readln().split(' ').map { it.toInt() }
    val ll = java.util.LinkedList<P>()
    val v = IntArray(200000)
    ll.add(P(n, 0))

    while (ll.isNotEmpty()) {
        val l = ll.removeFirst()
        val pos = l.p
        val time = l.t

        if (pos == k)
            return print(time)

        for ((n, i) in arrayOf(pos - 1, pos + 1, pos * 2).withIndex()) {
            if (i in 0..100_000) {
                if (v[i] == 0 || v[i] == v[pos] + 1) {
                    v[i] = v[pos] + 1
                    (if (n == 2) ll::addFirst else ll::addLast)(P(i, time + if (n == 2) 0 else 1))
                }
            }
        }
    }
}
