fun main() {
    val n = readln().toInt()
    val a = readln().split(' ').map { it.toInt() }
    val DP = Array(n) { 1 }

    for ((i, cur) in a.withIndex()) {
        var m = 0
        for (prev in 0..<i) {
            if (cur > a[prev]) {
                m = maxOf(DP[prev], m)
            }
        }
        DP[i] = m + 1
    }
    print(DP.max())
}
