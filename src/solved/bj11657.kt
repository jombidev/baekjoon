const val INF = 500 * 10000 + 1L
fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val edges = ArrayList<Triple<Int, Int, Int>>()

    repeat(m) {
        val (a, b, c) = readln().split(' ').map { it.toInt() }
        edges.add(Triple(a, b, c))
    }

    val d = LongArray(n + 1) { INF }
    d[1] = 0

    repeat(n) {
        for ((a, b, c) in edges) {
            if (d[a] == INF) continue
            d[b] = minOf(d[a] + c, d[b])
        }
    }

    for ((a, b, c) in edges) {
        if (d[a] == INF) continue
        if (d[a] + c < d[b])
            return print(-1)
    }

    print(d.drop(2).joinToString(" ") { "${if (it == INF) -1 else it}" })
}
