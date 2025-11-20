fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }

    val d = Array(n) { readln().split(' ').map { it.toInt() }.toIntArray() }
    val dst = d.map { it.indexOf(2) }
    val dstY = dst.indexOfFirst { it != -1 }
    val dstX = dst[dstY]

    class P(val x: Int, val y: Int, val t: Int)
    val r = Array(n) { y -> Array(m) { x -> if (d[y][x] == 0) 0 else -1 } }
    val v = Array(n) { BooleanArray(m) }
    r[dstY][dstX] = 0

    val vx = arrayOf(0, 0, 1, -1)
    val vy = arrayOf(1, -1, 0, 0)

    val ll = java.util.LinkedList<P>()
    ll.add(P(dstX, dstY, 0))

    while (ll.isNotEmpty()) {
        val p = ll.removeFirst()
        if (v[p.y][p.x])
            continue
        v[p.y][p.x] = true

        for (i in 0..<4) {
            val ox = p.x + vx[i]
            val oy = p.y + vy[i]

            if (ox !in 0..<m || oy !in 0..<n || v[oy][ox] || d[oy][ox] == 0)
                continue

            r[oy][ox] = p.t + 1
            ll.add(P(ox, oy, p.t + 1))
        }
    }

    print(r.joinToString("\n") { it.joinToString(" ") })
}
