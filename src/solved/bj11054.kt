fun main() {
    val n = readln().toInt()
    val a = readln().split(' ').map { it.toInt() }
    val ar = a.reversed()

    val DP = Array(n) { 1 }

    var ml = 1
    for ((i, cur) in a.withIndex()) {
        var m = 0
        for (prev in 0..<i) {
            if (cur > a[prev]) {
                m = maxOf(DP[prev], m)
            }
        }
        DP[i] = m + 1
        if (DP.max() == m + 1) {
            val DP2 = Array(n) { 1 }

            for ((j, cur) in ar.withIndex()) {
                if (j >= n - i) break
                var m = 0
                for (prev in 0..<j) {
                    if (cur > ar[prev]) {
                        m = maxOf(DP2[prev], m)
                    }
                }
                DP2[j] = m + 1
                ml = maxOf(DP.max() + DP2.max() - 1, ml)
            }
        }
    }

    print(ml)
}
