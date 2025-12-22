fun main() {
    val (n, k) = readln().split(' ').map { it.toInt() }

    val dp = Array(k + 1) { 0 }

    repeat(n) {
        val (w, v) = readln().split(' ').map { it.toInt() }

        for (i in k downTo w)
            dp[i] = maxOf(dp[i - w] + v, dp[i])
    }

    print(dp.last())
}
