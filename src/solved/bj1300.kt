fun main() {
    val n = readln().toInt()
    val k = readln().toInt()

    var l = 1
    var r = k

    while (l < r) {
        val m = l + (r - l).ushr(1)

        var s = 0
        for (k in 1..n)
            s += minOf(m / k, n)

        if (s >= k) {
            r = m
        } else {
            l = m + 1
        }
    }

    print(r)
}
