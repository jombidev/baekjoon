fun main() = System.`in`.bufferedReader().use {
    fun r() = it.readLine()
    class Node(val i: Int, var parent: Node? = null, val children: ArrayList<Node> = ArrayList())
    val (n, r, q) = r().split(' ').map { it.toInt() }
    val nodes = Array(n) { Node(it) }
    val edges = Array(n) { ArrayList<Int>() }
    val mem = IntArray(n)
    repeat(n - 1) {
        val (s, e) = r().split(' ').map { it.toInt() - 1 }
        edges[s].add(e)
        edges[e].add(s)
    }

    fun tree(node: Int = r - 1, parent: Int = -1) {
        for (e in edges[node]) {
            if (e == parent) continue

            nodes[node].children.add(nodes[e])
            nodes[e].parent = nodes[node]
            tree(e, node)
        }
    }

    fun subtree(root: Node): Int {
        if (mem[root.i] == 0) {
            val sums = root.children.sumOf { subtree(it) }
            mem[root.i] = sums + 1
        }

        return mem[root.i]
    }

    tree()

    val sb = StringBuilder()
    repeat(q) {
        val q = r().toInt()
        sb.append(subtree(nodes[q - 1])).append(' ')
    }
    print(sb)
}
