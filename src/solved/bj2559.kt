fun main() {
    val (n, k) = readln().split(' ').map { it.toInt() }
    val t = readln().split(' ').map { it.toInt() }.toIntArray()

    var r = k - 1
    var ps = t.take(k).sum()
    var mps = Int.MIN_VALUE

    while (r < n) {
        val l = r - k + 1

        mps = maxOf(mps, ps)

        r++
        if (r >= n) break

        ps -= t[l]
        ps += t[r]
    }

    print(mps)
}
