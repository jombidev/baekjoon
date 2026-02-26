fun main() = repeat(readln().toInt()) {
    val (n, k) = readln().split(' ').map { it.toInt() }
    val d = readln().split(' ').map { it.toInt() }.toIntArray()
    val e = Array(k) { readln().split(' ').map { it.toInt() } }
    val w = readln().toInt() - 1

    val edges = Array(n) { ArrayList<Int>() }
    val mem = IntArray(n) { -1 }

    for ((s, e) in e)
        edges[e - 1].add(s - 1)

    fun dfs(n: Int): Int {
        if (mem[n] == -1)
            mem[n] = (edges[n].maxOfOrNull { dfs(it) } ?: 0) + d[n]
        return mem[n]
    }

    println(dfs(w))
}
