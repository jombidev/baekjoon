fun main() {
    val n = readln().toInt()
    val DP = Array(n + 5) { false }
    DP[1] = true;DP[3] = true;DP[4] = true

    for (i in 5..n) {
        DP[i] = !(DP[i - 1] && DP[i - 3] && DP[i - 4])
    }

    print(if (DP[n]) "SK" else "CY")
}
