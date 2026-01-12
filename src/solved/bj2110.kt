fun main() = System.`in`.bufferedReader().use {
    fun r() = it.readLine()

    val (n, c) = r().split(' ').map { it.toInt() }
    val x = IntArray(n) { r().toInt() }
    x.sort()

    var l = 0
    var r = x.last() - x.first() + 1

    fun place(spc: Int): Int {
        var p = 0
        var last = -1

        for (i in x.indices) {
            if (last == -1 || x[i] - last >= spc) {
                last = x[i]
                p++
            }
        }

        return p
    }

    var res = 0

    while (l < r) {
        val m = l + (r - l).ushr(1)

        val p = place(m)

        if (p < c)
            r = m
        else {
            res = maxOf(res, m)
            l = m + 1
        }
    }

    print(res)
}
