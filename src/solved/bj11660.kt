fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val t = Array(n) { readln().split(' ').map { it.toInt() }.toIntArray() }
    val dp = Array(n + 1) { IntArray(n + 1) }
    dp[1][1] = t[0][0]

    for (i in 1..n)
        dp[1][i] = t[0][i - 1] + dp[1][i - 1]

    for (y in 2..n) {
        dp[y][1] = t[y - 1][0] + dp[y - 1][1]
        for (x in 2..n) {
            dp[y][x] = t[y - 1][x - 1] + dp[y - 1][x] + dp[y][x - 1] - dp[y - 1][x - 1]
        }
    }

    repeat(m) {
        val (y1, x1, y2, x2) = readln().split(' ').map { it.toInt() }

        println(dp[y2][x2] - dp[y1 - 1][x2] - dp[y2][x1 - 1] + dp[y1 - 1][x1 - 1])
    }
}
