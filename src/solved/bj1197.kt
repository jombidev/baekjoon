fun main() {
    var (v, e) = readln().split(' ').map { it.toInt() }
    val edges = Array(e) { readln().split(' ').map { it.toInt() } }.sortedBy { it[2] }
    val p = IntArray(v) { it }

    fun root(n: Int): Int {
        if (p[n] == n) {
            return n
        }

        p[n] = root(p[n])
        return p[n]
    }

    e = 0
    for ((s, d, w) in edges) {
        if (v == 1) break

        val s = root(s - 1)
        val d = root(d - 1)

        if (s != d) {
            p[s] = d
            e += w
            v--
        }
    }

    print(e)
}
