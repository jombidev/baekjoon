val MV = arrayOf(
    arrayOf(
        intArrayOf(0, 3, 6),
        intArrayOf(0, 3, 6),
        intArrayOf(0, 3, 6),
        intArrayOf(0, 3, 6),
    ),
    arrayOf(
        intArrayOf(8, 5, 2),
        intArrayOf(2, 1, 0),
        intArrayOf(6, 7, 8),
        intArrayOf(6, 7, 8),
    ),
    arrayOf(
        intArrayOf(6, 7, 8),
        intArrayOf(2, 1, 0),
        intArrayOf(8, 5, 2),
        intArrayOf(6, 7, 8),
    ),
    arrayOf(
        intArrayOf(0, 3, 6),
        intArrayOf(2, 1, 0),
        intArrayOf(2, 1, 0),
        intArrayOf(6, 7, 8),
    ),
    arrayOf( // intArrayOf(0, 1, 5, 3),
        intArrayOf(2, 1, 0),
        intArrayOf(2, 1, 0),
        intArrayOf(0, 3, 6),
        intArrayOf(6, 7, 8),
    ),
    arrayOf(
        intArrayOf(8, 5, 2),
        intArrayOf(8, 5, 2),
        intArrayOf(8, 5, 2),
        intArrayOf(8, 5, 2),
    ),
)
val ALLOWED = arrayOf(
    intArrayOf(3, 2, 1, 4),
    intArrayOf(0, 2, 5, 4),
    intArrayOf(0, 3, 5, 1),
    intArrayOf(0, 4, 5, 2),
    intArrayOf(0, 1, 5, 3),
    intArrayOf(4, 1, 2, 3),
)

fun main() = repeat(readln().toInt()) {
    val cube = Array(6) { Array(3) { CharArray(3) } }
    val tmp = Array(3) { CharArray(3) }

    fun planeRot(p: Int) {
        for (i in 0..8) {
            val y = i / 3
            val x = i % 3
            tmp[y][x] = cube[p][y][x]
        }
        for (i in 0..8) {
            val y = i / 3
            val x = i % 3
            cube[p][x][2 - y] = tmp[y][x]
        }
    }


    for (y in 0..2) {
        val k = readln().split(' ')
        for (x in 0..<18)
            cube[x / 3][y][x % 3] = k[x][0]
    }

    fun x(i: Int) = i % 3
    fun y(i: Int) = i / 3

    for (pos in readln()) {
        val n = "WORBGY".indexOf(pos)

        val mv = MV[n]
        val allowed = ALLOWED[n]

        for (i in 0..2)
            for (j in 0..2)
                tmp[i][j] = Char.MIN_VALUE

        tmp[y(mv[0][0])][x(mv[0][0])] = cube[allowed[0]][y(mv[0][0])][x(mv[0][0])]
        tmp[y(mv[0][1])][x(mv[0][1])] = cube[allowed[0]][y(mv[0][1])][x(mv[0][1])]
        tmp[y(mv[0][2])][x(mv[0][2])] = cube[allowed[0]][y(mv[0][2])][x(mv[0][2])]

        for (i in mv.indices) {
            val ni = (i + 1) % 4

            cube[allowed[i]][y(mv[i][0])][x(mv[i][0])] = cube[allowed[ni]][y(mv[ni][0])][x(mv[ni][0])]
            cube[allowed[i]][y(mv[i][1])][x(mv[i][1])] = cube[allowed[ni]][y(mv[ni][1])][x(mv[ni][1])]
            cube[allowed[i]][y(mv[i][2])][x(mv[i][2])] = cube[allowed[ni]][y(mv[ni][2])][x(mv[ni][2])]
        }

        cube[allowed.last()][y(mv.last()[0])][x(mv.last()[0])] = tmp[y(mv[0][0])][x(mv[0][0])]
        cube[allowed.last()][y(mv.last()[1])][x(mv.last()[1])] = tmp[y(mv[0][1])][x(mv[0][1])]
        cube[allowed.last()][y(mv.last()[2])][x(mv.last()[2])] = tmp[y(mv[0][2])][x(mv[0][2])]

        planeRot(n)
    }

    val sb = StringBuilder()
    for (y in 0..2) {
        for (i in 0..5) {
            for (ch in cube[i][y]) {
                sb.append(ch).append(' ')
            }
        }
        sb[sb.lastIndex] = '\n'
    }
    print(sb)
    println("===================================")
}
