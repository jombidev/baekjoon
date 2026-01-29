fun main() {
    val (n, k) = readln().split(' ').map { it.toInt() }
    val q = ArrayDeque(List(n) { it + 1 })
    val t = ArrayDeque<Int>(n)

    while (q.isNotEmpty()) {
        repeat(k - 1) { q.addLast(q.removeFirst()) }
        t.add(q.removeFirst())
    }

    print(t.joinToString(", ", "<", ">"))
}
