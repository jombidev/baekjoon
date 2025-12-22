fun main() {
    class P(val p: Int, val t: Int)
    val (n, k) = readln().split(' ').map { it.toInt() }
    val ll = java.util.LinkedList<P>()
    val v = IntArray(200000)
    ll.add(P(n, 0))

    val f = HashMap<Int, Int>()
    var lastTime = Int.MAX_VALUE

    while (ll.isNotEmpty()) {
        val l = ll.removeFirst()
        val pos = l.p
        val time = l.t

        if (pos == k) {
            if (lastTime < time)
                break
            lastTime = time
            f[time] = (f[time] ?: 0) + 1

        }

        for (i in arrayOf(pos - 1, pos + 1, pos * 2)) {
            if (i in 0..100000) {
                if (v[i] == 0 || v[i] == v[pos] + 1) {
                    v[i] = v[pos] + 1
                    ll.addLast(P(i, time + 1))
                }
            }
        }
    }

    println(lastTime)
    println(f[lastTime])
}
