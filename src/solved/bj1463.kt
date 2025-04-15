fun main() {
    val sz = readln().toInt()

    val DP = Array(sz + 1) { 0 }
    val m = Int.MAX_VALUE

    for (i in 2..sz) {
        DP[i] = minOf(
            DP[i - 1],
            if (i % 2 == 0) DP[i / 2] else m,
            if (i % 3 == 0) DP[i / 3] else m,
        ) + 1
    }

    println(DP[sz])
}
