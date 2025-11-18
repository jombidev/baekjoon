import java.util.LinkedList

val v = LinkedList<Int>()

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val g = Array(n) { it + 1 }
    bt(g, m)
}

fun bt(g: Array<Int>, limit: Int) {
    for (i in g.indices) {
        if (v.any { it == i })
            continue
        v.addLast(i)
        if (v.size == limit) {
            println(v.map { g[it] }.joinToString(" "))
        } else {
            bt(g, limit)
        }
        v.removeLast()
    }
}
