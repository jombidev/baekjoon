fun main() {
    repeat(readln().toInt()) {
        val n = readln().toInt()
        val s = Array(2) { readln().split(' ').map { it.toInt() }.toIntArray() }

        when (n) {
            1 -> println(maxOf(s[0][0], s[1][0]))
            2 -> println(maxOf(s[0][0] + s[1][1], s[0][1] + s[1][0]))
            else -> {
                val dp = Array(2) { IntArray(n) }
                dp[0][0] = s[0][0]
                dp[1][0] = s[1][0]
                dp[0][1] = s[1][0] + s[0][1]
                dp[1][1] = s[1][1] + s[0][0]

                for (i in 2..<n) {
                    dp[0][i] = s[0][i] + maxOf(dp[1][i - 1], dp[0][i - 2], dp[1][i - 2])
                    dp[1][i] = s[1][i] + maxOf(dp[0][i - 1], dp[0][i - 2], dp[1][i - 2])
                }

                println(dp.maxOf { it.last() })
            }
        }
    }
}
