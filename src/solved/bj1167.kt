import java.util.PriorityQueue

fun main() {
    class Node(val links: MutableList<Pair<Int, Int>>)

    val n = readln().toInt()
    val nodes = List(n + 1) { Node(mutableListOf()) }

    repeat(n) {
        val m = readln().split(' ').map { it.toInt() }
        val node = nodes[m.first()]
        for ((e, t) in m.drop(1).dropLast(1).chunked(2)) {
            node.links.add(e to t)
        }
    }

    fun dfs(start: Int, prevExp: Int = 0, v: BooleanArray): Pair<Int, Int> { // node-n, len
        v[start] = true
        var maxNode = 0 to 0
        for ((end, exp) in nodes[start].links) {
            if (v[end]) continue

            val result = dfs(end, exp + prevExp, v=v)
            if (maxNode.second < result.second)
                maxNode = result
        }

        if (maxNode.first == 0)
            return start to prevExp

        return maxNode
    }

    val firstOp = dfs(1, v = BooleanArray(n + 1))
    val secondOp = dfs(firstOp.first, v = BooleanArray(n + 1))
    print(secondOp.second)
}
