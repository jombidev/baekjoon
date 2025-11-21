fun main() {
    val n = readln().toInt()
    val dp = Array(n + 1) { IntArray(10) }
    dp[1] = intArrayOf(0, 1, 1, 1, 1, 1, 1, 1, 1, 1)

    for (i in 2..n) {
        dp[i][0] = dp[i - 1][1]
        dp[i][9] = dp[i - 1][8]

        for (j in 1..8)
            dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000
    }

    print(dp[n].sumOf { it.toLong() } % 1_000_000_000L)
}
