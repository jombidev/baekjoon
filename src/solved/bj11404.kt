fun main() {
    val n = readln().toInt()

    val e = Array(n + 1) { Array(n + 1) { Int.MAX_VALUE } }

    for (i in 0..n)
        e[i][i] = 0

    repeat(readln().toInt()) {
        val (x, y, p) = readln().split(' ').map { it.toInt() }
        e[x][y] = minOf(e[x][y], p)
    }

    for (m in 1..n)
        for (i in 1..n)
            for (j in 1..n) {
                if (e[i][m] != Int.MAX_VALUE && e[m][j] != Int.MAX_VALUE)
                    e[i][j] = minOf(e[i][j], e[i][m] + e[m][j])
            }

    print(e.drop(1).joinToString("\n") { it.drop(1).joinToString(" ") { "${if (it == Int.MAX_VALUE) 0 else it}" } })
}
