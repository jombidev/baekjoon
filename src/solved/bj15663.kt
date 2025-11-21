import java.util.LinkedList

val v = LinkedList<Int>()
val ls = LinkedHashSet<String>()

fun main() {
    val (_, m) = readln().split(' ').map { it.toInt() }
    val g = readln().split(' ').map { it.toInt() }.sorted().toIntArray()
    bt(g, m)
    print(ls.joinToString("\n"))
}

fun bt(g: IntArray, limit: Int) {
    for (i in g.indices) {
        if (v.any { it == i })
            continue
        v.addLast(i)
        if (v.size == limit) {
            val curr = v.map { g[it] }.joinToString(" ")
            ls.add(curr)
        } else {
            bt(g, limit)
        }
        v.removeLast()
    }
}
