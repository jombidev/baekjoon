fun main() {
    val (c, n) = readln().split(' ').map { it.toInt() }
    val b = Array(n) { readln().split(' ').map { it.toInt() }.let { (w, p) -> w to p } }

    val dp = Array(100001) { 0 }

    for (i in 0..100000) {
        for ((w, p) in b) {
            if (i - w >= 0) dp[i] = maxOf(dp[i - w] + p, dp[i])
            if (dp[i] >= c) return print(i)
        }
    }
}
