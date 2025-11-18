fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val s = List(n) { readln() }
    val t = HashMap<String, Int>()

    for (w in s) {
        if (w.length < m)
            continue
        t[w] = (t[w] ?: 0) + 1
    }

    println(
        t.toList()
        .sortedWith(
            Comparator
                .comparingInt<Pair<String, Int>> { -it.second }
                .thenComparingInt { -it.first.length }
                .thenBy { it.first }
        )
        .joinToString("\n") { it.first }
    )
}
