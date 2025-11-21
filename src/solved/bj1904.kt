fun main() {
    val n = readln().toInt()

    val dp = Array(n + 2) { 0 }
    dp[0] = 1
    dp[1] = 1
    dp[2] = 2

    for (i in 3..n) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 15746
    }

    print(dp[n])
}
