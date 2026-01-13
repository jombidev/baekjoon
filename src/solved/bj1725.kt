fun main() {
    val n = readln().toInt()
    val h = Array(n) { readln().toInt() }

    fun dnc(l: Int, r: Int): Int {
        if (l == r)
            return h[l]

        val m = l + (r - l).ushr(1)

        var i = m
        var j = m + 1
        var w = Int.MAX_VALUE
        var a = 0

        while (l <= i && j <= r) {
            w = minOf(w, h[i], h[j])
            a = maxOf(a, w * (j - i + 1))

            if (l == i) j++
            else if (j == r) i--
            else if (h[i - 1] < h[j + 1]) j++
            else i--
        }

        return maxOf(a, dnc(l, m), dnc(m + 1, r))
    }

    print(dnc(0, n - 1))
}
