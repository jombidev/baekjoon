data class N(val l: Int?, val r: Int?)

fun main() {
    val n = readln().toInt()
    val nn = Array(n) { readln().split(' ').map { (it[0] - 'A').takeIf { it != -19 } } }.associate { it[0] to (it[1] to it[2]) }
    val nodes = Array(n) {
        val (l, r) = nn[it]!!
        N(l, r)
    }

    val rs = Array(3) { StringBuilder() }
    nodes.dfs(0, rs)
    for (sb in rs) {
        println(sb)
    }
}

fun Array<N>.dfs(n: Int?, fix: Array<StringBuilder>) {
    if (n == null)
        return

    val t = this[n]

    fix[0].append('A' + n)
    dfs(t.l, fix)
    fix[1].append('A' + n)
    dfs(t.r, fix)
    fix[2].append('A' + n)
}
