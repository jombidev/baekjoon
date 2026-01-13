fun main() {
    val n = readln().toInt()
    val p = Array(n) { readln().split(' ').map { it.toInt() }.toIntArray() }

    val c = IntArray(3)

    fun dnc(x: Int, y: Int, d: Int): Int? { // pure?
        if (d == 1) return p[y][x]

        val td = d / 3
        var pure: MutableMap<Int, Int>? = HashMap()

        for (i in 0..<3) {
            for (j in 0..<3) {
                val xx = x + j * td
                val yy = y + i * td
                val pn = dnc(xx, yy, td)

                if (pure == null) {
                    if (pn == null) continue
                    c[pn + 1]++
                    continue
                }
                if (pn == null) {
                    for ((key, value) in pure) {
                        c[key + 1] += value
                    }
                    pure = null
                } else {
                    pure[pn] = pure.getOrDefault(pn, 0) + 1
                    if (pure.size > 1) {
                        for ((key, value) in pure) {
                            c[key + 1] += value
                        }
                        pure = null
                    }
                }
            }
        }

        return pure?.iterator()?.next()?.key
    }

    val d = dnc(0, 0, n)
    if (d != null) {
        c[d + 1]++
    }

    print(c.joinToString("\n"))
}
