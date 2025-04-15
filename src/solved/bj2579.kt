fun main() {
    val sz = readln().toInt()
    val tar = List(sz) { readln().toInt() } + listOf(0)
    val DP = Array(sz + 1) { Array(2) { 0 } }

    DP[0][1] = tar[0]
    DP[1][0] = tar[1] + DP[0][1]
    DP[1][1] = tar[1]

    for (i in 2..<tar.size) {
        val ar = DP[i]
        ar[0] = tar[i] + DP[i - 1][1]
        ar[1] = tar[i] + DP[i - 2].max()
    }

    println(DP[sz - 1].max())
}
