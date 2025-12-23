fun main() {
    data class P(val x: Int, val y: Int, val s: Int) {
        val noi
            get() = when (s) {
                0 -> 1
                1 -> 0
                else -> -1
            }
    }

    val sx = arrayOf(1, 0, 1)
    val sy = arrayOf(0, 1, 1)

    val n = readln().toInt()
    val r = 0..<n

    val a = Array(n) { readln().split(' ').map { it.toInt() }.toIntArray() }
    if (a[n - 1][n - 1] == 1)
        return print(0)

    fun dfs(p: P): Int {
        val dx = p.x + sx[p.s]
        val dy = p.y + sy[p.s]

        if (p.s == 2) {
            for (i in 0..<3) {
                val ox = p.x + sx[i]
                val oy = p.y + sy[i]

                if (p.x !in r || p.y !in r || a[p.y][p.x] == 1 || ox !in r || oy !in r || a[oy][ox] == 1)
                    return 0
            }
        } else {
            if (p.x !in r || p.y !in r || dx !in r || dy !in r || a[p.y][p.x] == 1 || a[dy][dx] == 1)
                return 0
        }

        if (dx == dy && dx == n - 1)
            return 1

        var cnt = 0

        for (i in 0..<3) {
            if (p.noi == i) continue

            cnt += dfs(P(dx, dy, i))
        }

        return cnt
    }

    print(dfs(P(0, 0, 0)))
}
