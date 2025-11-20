fun main() {
    val n = readln().toInt()
    val m = Array(n) { readln().split(' ').mapIndexedNotNull { i, n -> if (n == "1") i else null }.toSet() }

    val v = Array(n) { BooleanArray(n) }

    for (i in 0..<n)
        v.bfs(i, m)

    for (m in v) println(m.joinToString(" ") { "${if (it) 1 else 0}" })
}

fun Array<BooleanArray>.bfs(me: Int, m: Array<Set<Int>>) {
    val ll = java.util.LinkedList<Int>()
    ll.addAll(m[me])

    while (ll.isNotEmpty()) {
        val i = ll.removeFirst()
        if (this[me][i])
            continue
        this[me][i] = true

        ll.addAll(m[i])
    }
}
