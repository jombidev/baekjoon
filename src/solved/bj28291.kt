import java.util.LinkedList

fun main() {
    val (w, h) = readln().split(' ').map { it.toInt() }
    val f = Array(h) { IntArray(w) }
    val p = Array(h) { IntArray(w) }

    val chks = LinkedList<Triple<Int, Int, Int>>()
    val lamps = ArrayList<Pair<Int, Int>>()

    repeat(readln().toInt()) {
        val (b, x, y) = readln().split(' ')

        f[y.toInt()][x.toInt()] = when (b) {
            "redstone_block" -> 1
            "redstone_dust" -> 2
            else -> 3
        }

        if (b == "redstone_block")
            chks.add(Triple(x.toInt(), y.toInt(), 16))
        if (b == "redstone_lamp")
            lamps.add(x.toInt() to y.toInt())
    }

    val ox = arrayOf(1, -1, 0, 0)
    val oy = arrayOf(0, 0, 1, -1)

    while (chks.isNotEmpty()) {
        val (x, y, pow) = chks.removeFirst()

        if (f[y][x] == 3) {
            lamps.remove(x to y)
            continue
        }

        for (i in 0..<4) {
            val dx = x + ox[i]
            val dy = y + oy[i]

            if (dx !in 0..<w || dy !in 0..<h || f[dy][dx] !in 2..3 || p[dy][dx] >= pow - 1 || pow - 1 <= 0)
                continue

            chks.add(Triple(dx, dy, pow - 1))
        }
    }

    print(if (lamps.isEmpty()) "success" else "failed")
}
