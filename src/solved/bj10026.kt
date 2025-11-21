enum class ScanMode(vararg val sc: Char) {
    U(' '), R('R'), G('G'), B('B'), RG('R', 'G')
}

fun main() {
    val n = readln().toInt()
    val m = Array(n) { readln().toCharArray() }

    val v = Array(n) { Array(n) { ScanMode.U } }

    val r = m.bfs(v, ScanMode.R)
    val g = m.bfs(v, ScanMode.G)
    val b = m.bfs(v, ScanMode.B)
    val rg = m.bfs(v, ScanMode.RG)

    print("${r + g + b} ${rg + b}")
}

fun Array<CharArray>.bfs(v: Array<Array<ScanMode>>, sm: ScanMode): Int {
    var c = 0
    while (true) {
        val si = mapIndexed { y, q ->
            var x = - 1
            q.indexOfFirst { x++; it in sm.sc && v[y][x] != sm }
        }
        val sy = si.indexOfFirst { it != -1 }
        if (sy == -1)
            break
        val sx = si[sy]

        val ll = java.util.LinkedList<Pair<Int, Int>>()
        ll.add(sx to sy)

        val vx = arrayOf(1, -1, 0, 0)
        val vy = arrayOf(0, 0, 1, -1)

        while (ll.isNotEmpty()) {
            val (x, y) = ll.removeFirst()

            if (v[y][x] == sm)
                continue
            v[y][x] = sm

            for (i in 0..<4) {
                val ox = x + vx[i]
                val oy = y + vy[i]

                if (ox !in 0..<size || oy !in 0..<size || v[oy][ox] == sm || this[oy][ox] !in sm.sc)
                    continue

                ll.add(ox to oy)
            }
        }
        c++
    }

    return c
}
