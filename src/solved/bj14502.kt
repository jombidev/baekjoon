import java.util.LinkedList

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }

    val f = Array(n) { IntArray(m) }
    val emu = Array(n) { IntArray(m) }
    val z = LinkedList<Pair<Int, Int>>()

    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)

    repeat(n) { y ->
        for ((x, v) in readln().split(' ').map { it.toInt() }.withIndex()) {
            f[y][x] = v
            if (v == 2)
                z.add(x to y)
        }
    }

    val combos = LinkedList<List<Pair<Int, Int>>>()
    val combo = Array(3) { 0 to 0 }

    fun combination(i: Int = 0, d: Int = 0) {
        if (d == 3) {
            combos.add(combo.toList())
            return
        }

        for (j in i..<n * m) {
            val y = j / m
            val x = j % m

            if (f[y][x] == 0) {
                combo[d] = x to y
                combination(j + 1, d + 1)
            }
        }
    }

    combination()

    var mzc = 0
    while (combos.isNotEmpty()) {
        val w = combos.removeFirst()

        for (i in 0..<n)
            for (j in 0..<m)
                emu[i][j] = f[i][j]

        for ((x, y) in w) emu[y][x] = 1

        val ll = LinkedList(z)

        while (ll.isNotEmpty()) {
            val (x, y) = ll.removeFirst()

            for (i in 0..<4) {
                val ox = x + dx[i]
                val oy = y + dy[i]

                if (ox !in 0..<m || oy !in 0..<n || emu[oy][ox] != 0)
                    continue

                emu[oy][ox] = 2
                ll.add(ox to oy)
            }
        }

        var zc = 0
        for (i in 0..<n)
            for (j in 0..<m)
                if (emu[i][j] == 0)
                    zc++

        mzc = maxOf(mzc, zc)
    }

    print(mzc)
}
