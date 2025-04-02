fun main() {
    val br = System.`in`.bufferedReader()
    val (sz, lines) = br.readLine().split(' ').map { it.toInt() }
    val s = br.readLine().split(' ')
    var prev = -1
    var ans = 0
    val m = Array(sz) {
        val a = s[it].toInt()
        if (prev != a && a == 1)
            ans++
        prev = a
        a
    }
    val sb = StringBuilder()
    for (asdf in 0..< lines) {
        val c = br.readLine().split(' ').map { it.toInt() }
        when (c[0]) {
            0 -> sb.append(ans).append('\n')
            1 -> {
                val p = c[1] - 1
                if (m[p] == 1) continue
                m[p] = 1
                var o = 0
                if (p - 1 >= 0 && m[p - 1] == 1)
                    o++
                if (p + 1 < sz && m[p + 1] == 1)
                    o++
                when (o) {
                    0 -> ans++ // new
                    2 -> ans-- // connection
                }
            }
        }
    }
    println(sb)
    br.close()
}
