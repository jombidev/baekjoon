fun main() {
    val n = readln().toInt()
    val c = Array(n) {
        readln().split(' ').map { it.toDouble() }.let { (a, b) -> a to b }
    }

    var l = .0
    var r = .0

    for (i in c.indices) {
        val next = (i + 1) % n

        val q = c[i]
        val e = c[next]

        l += q.first * e.second
        r += q.second * e.first
    }

    print("%.1f".format(Math.round(Math.abs(l - r) / 2.0 * 10) / 10.0))
}
