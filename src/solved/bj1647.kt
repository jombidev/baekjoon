fun main() {
    var (n, m) = readln().split(' ').map { it.toInt() }
    val edges = Array(m) { readln().split(' ').map { it.toInt() } }.sortedBy { it[2] }
    val p = IntArray(n) { it }

    fun root(n: Int): Int {
        if (p[n] == n) {
            return n
        }

        p[n] = root(p[n])
        return p[n]
    }

    m = 0
    for ((s, d, w) in edges) {
        if (n == 2) break

        val s = root(s - 1)
        val d = root(d - 1)

        if (s != d) {
            p[s] = d
            m += w
            n--
        }
    }

    print(m)
}
