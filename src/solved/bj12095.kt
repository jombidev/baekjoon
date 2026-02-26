fun main() {
    val test = """0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 6 7 0 0 0 0 0 0
0 0 8 0 0 0 0 0 9
0 0 9 0 0 0 0 0 0""".split('\n').map { it.split(' ').map { it.toInt() }.toIntArray() }.toTypedArray()
//    val test = Array(9) { IntArray(9) }

    test.bt(5)

/*
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
5 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 6 7 0 0 0 0 0 0
0 0 8 0 0 0 0 0 9
0 0 9 0 0 0 0 0 0
 */
}

fun Array<IntArray>.placeable(x: Int, y: Int, n: Int): Boolean {
    for (i in indices) {
        if (this[y][i] == n) return false
        if (this[i][x] == n) return false
    }
    for (yy in 0..<3) {
        for (xx in 0..<3) {
            if (this[y / 3 * 3 + yy][x / 3 * 3 + xx] == n) return false
        }
    }

    return true
}

fun Array<IntArray>.bt(i: Int) {
    var maxRes = 0
    for (y in 0..<9) {
        for (x in 0..<9) {
            if (!placeable(x, y, i)) continue

            this[y][x] = i
            val res = sudoku(this)
            if (maxRes < res) {
                println(joinToString("\n") { it.joinToString(" ") })
                println(res)
                maxRes = res
            }
            this[y][x] = 0
        }
    }
}

fun sudoku(_a: Array<IntArray>): Int {
    val a = Array(9) { IntArray(9) }
    val c = Array(10) { BooleanArray(10) }
    val c2 = Array(10) { BooleanArray(10) }
    val c3 = Array(10) { BooleanArray(10) }
    val n = 9
    var cnt = 0

    fun square(x: Int, y: Int): Int = (x / 3) * 3 + (y / 3)

    fun go(z: Int): Boolean {
        cnt += 1
        if (cnt >= 10000000) return true
        if (z == 81) {
//            for (i in 0 until n) {
//                for (j in 0 until n) {
//                    print("${a[i][j]} ")
//                }
//                println()
//            }
            return true
        }
        val x = z / n
        val y = z % n
        if (a[x][y] != 0) {
            return go(z + 1)
        } else {
            for (i in 1..9) {
                if (!c[x][i] && !c2[y][i] && !c3[square(x, y)][i]) {
                    c[x][i] = true; c2[y][i] = true; c3[square(x, y)][i] = true
                    a[x][y] = i
                    if (go(z + 1)) return true
                    a[x][y] = 0
                    c[x][i] = false; c2[y][i] = false; c3[square(x, y)][i] = false
                }
            }
        }
        return false
    }

    for (i in 0..<n) {
        for (j in 0..<n) {
            a[i][j] = _a[i][j]
            if (_a[i][j] != 0) {
                c[i][a[i][j]] = true
                c2[j][a[i][j]] = true
                c3[square(i, j)][a[i][j]] = true
            }
        }
    }
    if (!go(0)) {
        println("WTF?")
        return -1
    }
    return cnt
}
