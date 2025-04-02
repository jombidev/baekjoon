fun main() {
    readln()
    val m = readln().split(' ').map { it.toInt() }
    val n = linkedSetOf<Int>()
    n.addAll(m)
    val h = hashMapOf<Int, Int>()
    for (i in m) {
        if (h[i] == null) h[i] = 0
        h[i] = h[i]!! + 1
    }
    println(n.sortedWith { a, b -> h[b]!! - h[a]!! }.joinToString(" ") { "$it ".repeat(h[it]!!).trim() })
}
