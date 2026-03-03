val MV = arrayOf(
    arrayOf(
        arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(0, 1, 2),
            intArrayOf(0, 1, 2),
            intArrayOf(0, 1, 2),
        ),
        arrayOf(
            intArrayOf(2, 1, 0),
            intArrayOf(2, 1, 0),
            intArrayOf(2, 1, 0),
            intArrayOf(2, 1, 0),
        ),
    ),
    arrayOf(
        arrayOf(
            intArrayOf(6, 7, 8),
            intArrayOf(6, 7, 8),
            intArrayOf(6, 7, 8),
            intArrayOf(6, 7, 8),
        ),
        arrayOf(
            intArrayOf(8, 7, 6),
            intArrayOf(8, 7, 6),
            intArrayOf(8, 7, 6),
            intArrayOf(8, 7, 6),
        ),
    ),
    arrayOf(
        arrayOf(
            intArrayOf(6, 7, 8),
            intArrayOf(8, 5, 2),
            intArrayOf(2, 1, 0),
            intArrayOf(0, 3, 6),
        ),
        arrayOf(
            intArrayOf(8, 7, 6),
            intArrayOf(6, 3, 0),
            intArrayOf(0, 1, 2),
            intArrayOf(2, 5, 8),
        ),
    ),
    arrayOf(
        arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(2, 5, 8),
            intArrayOf(8, 7, 6),
            intArrayOf(6, 3, 0),
        ),
        arrayOf(
            intArrayOf(2, 1, 0),
            intArrayOf(0, 3, 6),
            intArrayOf(6, 7, 8),
            intArrayOf(8, 5, 2),
        )
    ),
    arrayOf(
        arrayOf(
            intArrayOf(0, 3, 6),
            intArrayOf(8, 5, 2),
            intArrayOf(0, 3, 6),
            intArrayOf(0, 3, 6),
        ),
        arrayOf(
            intArrayOf(6, 3, 0),
            intArrayOf(6, 3, 0),
            intArrayOf(6, 3, 0),
            intArrayOf(2, 5, 8),
        ),
    ),
    arrayOf(
        arrayOf(
            intArrayOf(2, 5, 8),
            intArrayOf(2, 5, 8),
            intArrayOf(2, 5, 8),
            intArrayOf(6, 3, 0),
        ),
        arrayOf(
            intArrayOf(8, 5, 2),
            intArrayOf(0, 3, 6),
            intArrayOf(8, 5, 2),
            intArrayOf(8, 5, 2),
        ),
    ),
)
val ALLOWED = arrayOf(
    arrayOf(
        intArrayOf(2, 5, 3, 4),
        intArrayOf(2, 4, 3, 5),
    ),
    arrayOf(
        intArrayOf(2, 4, 3, 5),
        intArrayOf(2, 5, 3, 4),
    ),
    arrayOf(
        intArrayOf(0, 4, 1, 5),
        intArrayOf(0, 5, 1, 4),
    ),
    arrayOf(
        intArrayOf(0, 5, 1, 4),
        intArrayOf(0, 4, 1, 5),
    ),
    arrayOf(
        intArrayOf(0, 3, 1, 2),
        intArrayOf(0, 2, 1, 3),
    ),
    arrayOf(
        intArrayOf(0, 2, 1, 3),
        intArrayOf(0, 3, 1, 2),
    ),
)

fun main() {
    val br = java.util.StringTokenizer(System.`in`.reader().readText(), " \n")
    fun s() = br.nextToken()
    repeat(s().toInt()) {
        val cube = Array(6) { Array(3) { CharArray(3) } }
        val tmp = Array(3) { CharArray(3) }

        for (y in 0..2) {
            for (x in 0..2) {
                cube[0][y][x] = s()[0]
            }
        }
        val offset = intArrayOf(4, 2, 5, 3)
        for (y in 0..2) {
            for (x in 0..<3 * 4) {
                cube[offset[x / 3]][y][x % 3] = s()[0]
            }
        }
        for (y in 0..2) {
            for (x in 0..2) {
                cube[1][y][x] = s()[0]
            }
        }

        fun x(i: Int) = i % 3
        fun y(i: Int) = i / 3

        while (true) {
            val s = s()
            if (s.isEmpty()) break
            val cc = s[0] == '-'
            if (s == "0" || s.length < 2) break

            val n = "562413".indexOf(s[1])

            val cci = if (cc) 1 else 0
            val mv = MV[n][cci]
            val allowed = ALLOWED[n][cci]

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

            fun planeRot(p: Int) {
                for (i in 0..8) {
                    val y = i / 3
                    val x = i % 3
                    tmp[y][x] = cube[p][y][x]
                }
                for (i in 0..8) {
                    val y = i / 3
                    val x = i % 3
                    cube[p][if (cc) 2 - x else x][if (cc) y else (2 - y)] = tmp[y][x]
                }
            }
            planeRot(n)
        }

        val n = cube.map { it.flatMap { it.asIterable() }.toSet() }
        println(if (n.all { it.size == 1 } && n.flatten()
                .distinct().size == 6) "Yes, grandpa!" else "No, you are wrong!")
    }
}
