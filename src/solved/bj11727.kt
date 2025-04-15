fun main() {
    val sz = readln().toInt()
    val DP = Array(sz) { 0 }
    DP[0] = 1
    if (sz > 1) DP[1] = 3
    for (i in 2..<sz) {
        DP[i] = (DP[i - 1] + DP[i - 2] * 2) % 10007
    }
    println(DP.last())
}
