fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val a = readln().split(' ').map { it.toInt() }.toIntArray()
    val dp = LongArray(n + 1)
    val mod = LongArray(n + 1)

    fun c(i: Int) = i * (i - 1L) / 2L

    for (i in a.indices) {
        dp[i + 1] = dp[i] + a[i]
        mod[i + 1] = dp[i + 1] % m
    }

    print((0L..<m).sumOf { c(mod.count { i -> i == it }) })
}
