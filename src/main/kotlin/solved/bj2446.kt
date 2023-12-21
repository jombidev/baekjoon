package solved

fun main() {
    val d = readln().toInt()
    val m = Array(d*2-1) { Array(d*2-1) { '*' } }
    val c = d*2-2
    for ((j, i) in (0 until d).withIndex()) {
        if (i == 0) continue
        for (k in 0 until i) {
            m[j][k] = ' '
            m[j][c-k] = ' '
            m[c-j][k] = ' '
            m[c-j][c-k] = ' '
        }
    }
    println(m.joinToString("\n") { it.joinToString("").trimEnd() })
}