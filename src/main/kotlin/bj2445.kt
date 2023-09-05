fun main() {
    val d = readln().toInt()
    val m = Array(d*2-1) { Array(d*2) { '*' } }
    for ((j, i) in (d-1 downTo 1).withIndex()) {
        for (k in -i until i) {
            m[j][k + d] = ' '
            m[m.size-1-j][k + d] = ' '
        }
    }
    println(m.joinToString("\n") { it.joinToString("") })
}