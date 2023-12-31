package solved

val d2447 = readln().toInt()
val e2447 = Array(d2447) { Array(d2447) { '*' } }
fun main() = with(StringBuilder()) {
    dfs2447(d2447 / 3, d2447 / 3, d2447 / 3)
    val bw = System.out.bufferedWriter()
    for (c in e2447) {
        for (j in c) append("$j")
        append("\n")
    }
    bw.write("$this")
    bw.flush()
    bw.close()
}
fun dfs2447(len: Int, x: Int, y: Int) {
    if (len < 1) return
    for (i in 0 until len) for (j in 0 until len) e2447[x + i][y + j] = ' '
    val hl = len / 3
    for (i in -1..1) for (j in -1..1)
        dfs2447(hl, hl + x + i * len, hl + y + j * len)
}