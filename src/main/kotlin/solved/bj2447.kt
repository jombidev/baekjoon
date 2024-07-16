package solved

private val d = readln().toInt()
private val e = Array(d) { Array(d) { '*' } }
fun main() = with(StringBuilder()) {
    dfs2447(d / 3, d / 3, d / 3)
    val bw = System.out.bufferedWriter()
    for (c in e) {
        for (j in c) append("$j")
        append("\n")
    }
    bw.write("$this")
    bw.flush()
    bw.close()
}
fun dfs2447(len: Int, x: Int, y: Int) {
    if (len < 1) return
    for (i in 0 until len) for (j in 0 until len) e[x + i][y + j] = ' '
    val hl = len / 3
    for (i in -1..1) for (j in -1..1)
        dfs2447(hl, hl + x + i * len, hl + y + j * len)
}
