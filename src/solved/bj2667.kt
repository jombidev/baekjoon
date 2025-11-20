import java.util.LinkedList

fun main() {
    val n = readln().toInt()
    val h = Array(n) { readln().map { it-'0' }.toIntArray() }
    val danji = LinkedList<Int>()

    val vx = arrayOf(0, 0, 1, -1)
    val vy = arrayOf(1, -1, 0, 0)

    while (true) {
        val e = h.map { it.indexOf(1) }
        val ey = e.indexOfFirst { it != -1 }
        if (ey == -1)
            break
        val ex = e[ey]

        val ll = LinkedList<Pair<Int, Int>>()
        ll.add(ex to ey)
        var cnt = 0

        while (ll.isNotEmpty()) {
            val (x, y) = ll.removeFirst()
            if (h[y][x] == 0)
                continue

            h[y][x] = 0
            cnt++

            for (i in 0..<4) {
                val ox = x + vx[i]
                val oy = y + vy[i]
                if (ox !in 0..<n || oy !in 0..<n || h[oy][ox] == 0)
                    continue

                ll.add(ox to oy)
            }
        }

        danji.add(cnt)
    }

    println(danji.size)
    print(danji.sorted().joinToString("\n"))
}
