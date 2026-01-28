import java.util.*

fun main() {
    val (n, m, r) = readln().split(' ').map { it.toInt() }
    class Node(val edges: MutableList<Int>)
    val e = Array(n + 1) { Node(LinkedList()) }
    val vis = IntArray(n + 1)

    repeat(m) {
        val (l, r) = readln().split(' ').map { it.toInt() }
        e[l].edges.add(r)
        e[r].edges.add(l)
    }

    e.forEach { it.edges.sortBy { -it } }

    var knock = 0

    fun dfs(o: Int) {
        vis[o] = ++knock

        for (i in e[o].edges) {
            if (vis[i] != 0) continue
            dfs(i)
        }
    }

    dfs(r)
    print(vis.drop(1).joinToString(" "))
}
