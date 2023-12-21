package solved

val d = readln().toInt()
val e = Array(d) { Array(d * 2 - 1) { '*' } }
fun main() = with(StringBuilder()) {
    if (d ==3) return@with print("  *  \n * * \n*****")
    val dh = d * 2 - 1
    for (i in 0 until d) for (j in e[i].indices)
        if (j < d - i - 1) {
            e[i][j] = ' '
            e[i][dh - j - 1] = ' '
        }
    dfs(d, d / 2, d / 2, 0)
    val bw = System.out.bufferedWriter()
    for (c in e) {
        for (j in c) append("$j")
        append("\n")
    }
    bw.write("$this")
    bw.flush()
    bw.close()
}
fun dfs(len: Int, x: Int, y: Int, stmt: Int) {
    if (len <= 1) return
    for (i in 0 until len / 2)
        for (j in 0 until len - 1) {
            if (len == 3 && j == 1 && i == 0) {
                if (stmt != 3) e[x][y] = '*'
                when (stmt) {
                    1 -> e[x - 1][y + 1] = ' '
                    2 -> e[x][y + 1] = ' '
                    3 -> e[x][y] = ' '
                }
                continue
            }
            if (i <= j && j <= len - 1 - i - 1) e[x + i][y + j] = ' '
        }
    val hl = len / 2
    dfs(hl, x - hl / 2, y + hl / 2, 1)
    dfs(hl, x + hl / 2, y + hl + hl / 2, 2)
    dfs(hl, x + hl / 2, y - hl / 2, 3)
}