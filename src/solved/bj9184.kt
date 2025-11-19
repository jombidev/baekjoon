val dp = Array(21) { Array(21) { Array(21) { 0 } } }
fun main() {
    while (true) {
        val (a, b, c) = readln().split(' ').map { it.toInt() }
        if (a == b && b == c && c == -1) return

        println("w($a, $b, $c) = ${w(a, b, c)}")
    }
}

fun w(a: Int, b: Int, c: Int): Int {
    if (a <= 0 || b <= 0 || c <= 0)
        return 1

    if (a > 20 || b > 20 || c > 20)
        return w(20, 20, 20)

    if (a < b && b < c) {
        if (dp[a][b][c - 1] == 0)
            dp[a][b][c - 1] = w(a, b, c - 1)
        if (dp[a][b - 1][c - 1] == 0)
            dp[a][b - 1][c - 1] = w(a, b - 1, c - 1)
        if (dp[a][b - 1][c] == 0)
            dp[a][b - 1][c] = w(a, b - 1, c)

        return dp[a][b][c - 1] + dp[a][b - 1][c - 1] - dp[a][b - 1][c]
    }

    if (dp[a - 1][b][c] == 0)
        dp[a - 1][b][c] = w(a - 1, b, c)
    if (dp[a - 1][b - 1][c] == 0)
        dp[a - 1][b - 1][c] = w(a - 1, b - 1, c)
    if (dp[a - 1][b][c - 1] == 0)
        dp[a - 1][b][c - 1] = w(a - 1, b, c - 1)
    if (dp[a - 1][b - 1][c - 1] == 0)
        dp[a - 1][b - 1][c - 1] = w(a - 1, b - 1, c - 1)

    return dp[a - 1][b][c] + dp[a - 1][b - 1][c] + dp[a - 1][b][c - 1] - dp[a - 1][b - 1][c - 1]
}
