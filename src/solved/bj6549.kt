fun main() = System.`in`.bufferedReader().readLines().forEach {
    val st = java.util.StringTokenizer(it, " ")

    val n = st.nextToken().toInt()
    if (n == 0) return@forEach
    val h = LongArray(n) { st.nextToken().toLong() }

    fun dnc(l: Int, r: Int): Long {
        if (l == r)
            return h[l]

        val m = l + (r - l).ushr(1)

        var i = m
        var j = m + 1
        var w = Long.MAX_VALUE
        var a = 0L

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

    println(dnc(0, n - 1))
}
