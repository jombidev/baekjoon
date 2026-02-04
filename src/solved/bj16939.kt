val MV = arrayOf(
    arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, 1),
        intArrayOf(0, 1),
        intArrayOf(0, 1),
    ), // U-
    arrayOf(
        intArrayOf(1, 0),
        intArrayOf(1, 0),
        intArrayOf(1, 0),
        intArrayOf(1, 0),
    ), // U+
    arrayOf(
        intArrayOf(3, 2),
        intArrayOf(1, 3),
        intArrayOf(0, 1),
        intArrayOf(2, 0),
    ), // F-
    arrayOf(
        intArrayOf(2, 3),
        intArrayOf(0, 2),
        intArrayOf(1, 0),
        intArrayOf(3, 1),
    ), // F+
    arrayOf(
        intArrayOf(3, 2),
        intArrayOf(3, 2),
        intArrayOf(3, 2),
        intArrayOf(3, 2),
    ), // D-
    arrayOf(
        intArrayOf(2, 3),
        intArrayOf(2, 3),
        intArrayOf(2, 3),
        intArrayOf(2, 3),
    ), // D+
    arrayOf(
        intArrayOf(2, 0),
        intArrayOf(1, 3),
        intArrayOf(2, 0),
        intArrayOf(2, 0),
    ), // L-
    arrayOf(
        intArrayOf(0, 2),
        intArrayOf(0, 2),
        intArrayOf(0, 2),
        intArrayOf(3, 1),
    ), // L+
    arrayOf(
        intArrayOf(1, 3),
        intArrayOf(1, 3),
        intArrayOf(1, 3),
        intArrayOf(2, 0),
    ), // R-
    arrayOf(
        intArrayOf(3, 1),
        intArrayOf(0, 2),
        intArrayOf(3, 1),
        intArrayOf(3, 1),
    ), // R+
    arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 3),
        intArrayOf(3, 2),
        intArrayOf(2, 0),
    ), // B-
    arrayOf(
        intArrayOf(1, 0),
        intArrayOf(0, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 1),
    ), // B+
)
val ALLOWED = arrayOf(
    intArrayOf(1, 4, 5, 3), // U-
    intArrayOf(1, 3, 5, 4), // U+
    intArrayOf(0, 3, 2, 4), // F-
    intArrayOf(0, 4, 2, 3), // F+
    intArrayOf(1, 3, 5, 4), // D-
    intArrayOf(1, 4, 5, 3), // D+
    intArrayOf(0, 5, 2, 1), // L-
    intArrayOf(0, 1, 2, 5), // L+
    intArrayOf(0, 1, 2, 5), // R-
    intArrayOf(0, 5, 2, 1), // R+
    intArrayOf(0, 4, 2, 3), // B-
    intArrayOf(0, 3, 2, 4), // B+
)

fun main() {
    val cube = Array(6) { Array(2) { IntArray(2) } }
    val tmp = Array(2) { IntArray(2) { -1 } }

    for ((i, c) in readln().split(' ').map { it.toInt() }.withIndex()) {
        val ci = i / 4
        val cy = i % 4 / 2
        val cx = i % 2

        cube[ci][cy][cx] = c - 1
    }

    fun x(i: Int) = i % 2
    fun y(i: Int) = i / 2

    for (i in ALLOWED.indices) {
        val mvCube = Array(6) { i -> Array(2) { j -> cube[i][j].copyOf() } }

        val mv = MV[i]
        val allowed = ALLOWED[i]

        tmp[y(mv[0][0])][x(mv[0][0])] = mvCube[allowed[0]][y(mv[0][0])][x(mv[0][0])]
        tmp[y(mv[0][1])][x(mv[0][1])] = mvCube[allowed[0]][y(mv[0][1])][x(mv[0][1])]

        for (i in mv.indices) {
            val ni = (i + 1) % 4

            mvCube[allowed[i]][y(mv[i][0])][x(mv[i][0])] = mvCube[allowed[ni]][y(mv[ni][0])][x(mv[ni][0])]
            mvCube[allowed[i]][y(mv[i][1])][x(mv[i][1])] = mvCube[allowed[ni]][y(mv[ni][1])][x(mv[ni][1])]
        }

        mvCube[allowed.last()][y(mv.last()[0])][x(mv.last()[0])] = tmp[y(mv[0][0])][x(mv[0][0])]
        mvCube[allowed.last()][y(mv.last()[1])][x(mv.last()[1])] = tmp[y(mv[0][1])][x(mv[0][1])]

        for (n in 0..3) {
            val y = n / 2
            val x = n % 2
            tmp[y][x] = mvCube[i / 2][y][x]
        }
        for (n in 0..3) {
            val y = n / 2
            val x = n % 2
            mvCube[i / 2][if (i % 2 == 0) 1 - x else x][if (i % 2 == 0) y else (1 - y)] = tmp[y][x]
        }

        val n = mvCube.map { it.flatMap { it.asIterable() }.toSet() }
        if (n.all { it.size == 1 } && n.flatten().distinct().size == 6) return print(1)
    }
    print(0)
}
