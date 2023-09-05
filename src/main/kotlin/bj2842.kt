fun main() {
    val size = readln().toInt()
    val xPath = listOf(1, -1, 0, 0, 1, -1, 1, -1)
    val yPath = listOf(0, 0, 1, -1, 1, -1, -1, 1)
    val t = List(size) { readln() }
    val f = Array(size) { readln().split(' ').mapIndexed { j, s -> arrayOf(it, j, t[it][j].code, s.toInt()) }.toTypedArray() }
    val v = Array(size) { Array(size) { false } }
    val q = ArrayDeque<Array<Int>>()
    val u = hashSetOf<Int>()
    q.add(arrayOf(*f.flatten().find { it[2] == 'P'.code }!!, 0, 0))
    while (q.isNotEmpty()) {
        val h = q.removeFirst()
        for (z in xPath.indices) {
            val xx = h[0] + xPath[z]
            val yy = h[1] + yPath[z]
            if (xx !in 0 until size || yy !in 0 until size || v[xx][yy]) continue
            val l = f[yy][xx]
            v[xx][yy] = true
            q.add(arrayOf(xx, yy, h[2], h[3], minOf(h[4], l[3]), maxOf(h[5], l[3])))
        }
    }
    print(u.min())
}