fun main() {
    val sz = readln().toInt()
    val tar = List(sz) { readln().toInt() }
    val DP = Array(sz) { 0 }

    DP[0] = tar[0]
    if (sz > 1)
        DP[1] = tar[1] + DP[0]
    if (sz > 2)
        DP[2] = maxOf(
            DP[1],
            DP[0] + tar[2],
            tar[1] + tar[2]
        )

    for (i in 3..<tar.size) {
        DP[i] = maxOf(
            DP[i - 1],
            DP[i - 2] + tar[i],
            DP[i - 3] + tar[i - 1] + tar[i],
            DP[i - 3] + tar[i],
        )
    }

    print(DP.last())
}
