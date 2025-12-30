fun main() {
    val n = readln().toInt()
    if (n == 1) return print("0 1")
    val f = Array(n + 1) { 0 }
    f[1] = 1

    for (i in 2..n) {
        f[i] = f[i - 1] + f[i - 2]
    }

    print("${f[n - 1]} ${f[n]}")
}

/*
fun main() {
    val n = readln().toInt()

    val dp = Array(n + 2) { 0 to 0 }
    dp[0] = 1 to 0
    dp[1] = 0 to 1
    dp[2] = 1 to 1

    for (i in 3..n) {
        val (a, b) = dp[i - 1]
        dp[i] = b to a + b
    }

    val (a, b) = dp[n]
    print("$a $b")
}
*/
