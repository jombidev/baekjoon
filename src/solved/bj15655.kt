import java.util.LinkedList

val v = LinkedList<Int>()
val sb = StringBuilder()

fun main() {
    val (_, m) = readln().split(' ').map { it.toInt() }
    val g = readln().split(' ').map { it.toInt() }.sorted().toIntArray()
    bt(g, m)
    print(sb.toString())
}

fun bt(g: IntArray, limit: Int) {
    for (i in g.indices) {
        if (v.any { it >= i })
            continue
        v.addLast(i)
        if (v.size == limit) {
            sb.append(v.map { g[it] }.joinToString(" ")).append('\n')
        } else {
            bt(g, limit)
        }
        v.removeLast()
    }
}
