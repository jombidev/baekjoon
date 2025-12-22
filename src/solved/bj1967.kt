import java.util.PriorityQueue

fun main() {
    class Node(val links: MutableList<Pair<Int, Int>>)

    val n = readln().toInt()

    val nodes = List(n + 1) { Node(mutableListOf()) }

    repeat(n - 1) {
        val (x, y, p) = readln().split(' ').map { it.toInt() }

        nodes[x].links.add(y to p)
    }

    var maxLen = 0

    fun dfs(node: Node): Int { // maxLen
        val pq = PriorityQueue<Int>(reverseOrder())
        var maxT = 0
        for ((y, p) in node.links) {
            val v = dfs(nodes[y])

            pq.add(p + v)

            maxT = maxOf(p + v, maxT)
        }

        if (pq.size > 1) maxLen = maxOf(maxLen, pq.remove() + pq.remove())
        else if (pq.size == 1) maxLen = maxOf(maxLen, pq.remove())
        return maxT
    }

    dfs(nodes[1])
    println(maxLen)
}
