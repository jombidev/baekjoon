fun main() {
    val dp = Array(10) { 0 }
    dp[0] = 1
    dp[1] = 2
    dp[2] = 4

    for (i in 3..<10) {
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
    }

    repeat(readln().toInt()) {
        println(dp[readln().toInt() - 1])
    }
}
