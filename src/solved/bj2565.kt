fun main() {
    val n = readln().toInt()
    val a = Array(n) { readln().split(' ').map { it.toInt() } }
    a.sortBy { it[0] }

    val DP = Array(n) { 1 }

    for ((i, cur) in a.withIndex()) {
        var m = 0
        for (prev in 0..<i) {
            if (cur[1] > a[prev][1]) {
                m = maxOf(DP[prev], m)
            }
        }
        DP[i] = m + 1
    }
    print(n - DP.max())
}
