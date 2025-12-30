fun main() {
    val (y, x, n) = readln().split(' ').map { it.toInt() }
    val c = Array(y) { readln().toCharArray() }
    val ss = Array(2) { Array(y + 1) { IntArray(x + 1) } } // 0: WBWB, 1: BWBW
    val t = arrayOf("WB", "BW")

    for (i in 0..<y) {

        for (j in 0..<x) {
            val p = (j % 2 + i) % 2

            for (k in 0..1)
                ss[k][i + 1][j + 1] = ss[k][i][j + 1] + ss[k][i + 1][j] - ss[k][i][j] + if (c[i][j] != t[k][p]) 1 else 0
        }
    }

    var min = Int.MAX_VALUE
    for (i in n..y) {
        for (j in n..x) {
            min = minOf(min, ss.minOf { it[i][j] - it[i - n][j] - it[i][j - n] + it[i - n][j - n] })
        }
    }
    print(min)
}
