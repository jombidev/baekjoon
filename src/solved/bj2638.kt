import java.util.LinkedList

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val c = Array(n) { readln().split(' ').map { it.toInt() }.toTypedArray() }
    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)

    var age = 0

    val empty = LinkedList<Pair<Int, Int>>() // x to y
    for (i in 0..<n) {
        empty.add(0 to i)
        empty.add(m - 1 to i)
    }
    for (i in 0..<m) {
        empty.add(i to 0)
        empty.add(i to n - 1)
    }

    val ones = ArrayList<Pair<Int, Int>>()
    for (i in 0..<n) for (j in 0..<m) if (c[i][j] == 1) // n^2???!?!?
        ones.add(j to i)

    while (ones.isNotEmpty()) {
        while (empty.isNotEmpty()) { // empty cleaning bfs
            val (x, y) = empty.removeFirst()

            if (c[y][x] != 0)
                continue

            c[y][x] = -1 // outside mark

            for (i in 0..<4) {
                val ox = x + dx[i]
                val oy = y + dy[i]

                if (ox !in 0..<m || oy !in 0..<n || c[oy][ox] != 0)
                    continue

                empty.add(ox to oy)
            }
        }

        for (p in ones) {
            val (x, y) = p

            var cnt = 0

            for (i in 0..<4) {
                val ox = x + dx[i]
                val oy = y + dy[i]

                if (ox !in 0..<m || oy !in 0..<n || c[oy][ox] != -1)
                    continue

                cnt++
            }

            if (cnt >= 2) empty.add(p)
        }

        for ((x, y) in empty) {
            c[y][x] = 0
            ones.remove(x to y)
        }

        age++
    }

    print(age)
}
