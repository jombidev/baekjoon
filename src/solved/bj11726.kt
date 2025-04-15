fun main() {
    val n = readln().toInt()
    val DP = Array(n + 2) { 0 }
    DP[1] = 1
    DP[2] = 2

    for (i in 3..n) {
        DP[i] = (DP[i - 1] + DP[i - 2]) % 10007
    }

    print(DP[n])
}
