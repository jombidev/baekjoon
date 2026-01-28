fun main() {
    val (m, n, q) = readln().split(' ').map { it.toInt() }
    val p = readln().split(' ').map { it.toInt() }
    val ps = IntArray(n) { p[it] }

    repeat(m) {
        println("? ${it + 1} ${it + 1}")
        System.out.flush()

        val t = readln().toInt() - 1
        ps[it] = t
    }

    println("! ${ps.mapIndexed { i, it -> if (it == 0) p[i] else it }.joinToString(" ")}")
}
