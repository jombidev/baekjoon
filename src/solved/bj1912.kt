fun main() {
    val n = readln().toInt()
    val s = readln().split(' ').map { it.toInt() }

    val dp = IntArray(n)
    dp[0] = s[0]

    var m = dp[0]

    for (i in 1..<n) {
        dp[i] = maxOf(dp[i - 1] + s[i], s[i])
        m = maxOf(m, dp[i])
    }
    print(m)
}
