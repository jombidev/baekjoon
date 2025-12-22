fun main() {
    val dp = Array(2) { IntArray(3) }

    repeat(readln().toInt()) {
        val (a, b, c) = readln().split(' ').map { it.toInt() }

        var sl = dp[0][0]
        var sc = dp[0][1]
        var sr = dp[0][2]
        dp[0][0] = maxOf(sl, sc) + a
        dp[0][1] = maxOf(sl, sc, sr) + b
        dp[0][2] = maxOf(sc, sr) + c

        sl = dp[1][0]
        sc = dp[1][1]
        sr = dp[1][2]
        dp[1][0] = minOf(sl, sc) + a
        dp[1][1] = minOf(sl, sc, sr) + b
        dp[1][2] = minOf(sc, sr) + c
    }

    print("${dp[0].max()} ${dp[1].min()}")
}
