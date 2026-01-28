class Node {
    val edges = java.util.LinkedList<Int>()
}

const val Z = 0.toByte()
const val O = 1.toByte()
const val T = 2.toByte()

fun main() = repeat(readln().toInt()) {
    val (v, e) = readln().split(' ').map { it.toInt() }
    val nodes = Array(v + 1) { Node() }
    val visited = ByteArray(v + 1) { 0 }

    repeat(e) {
        val (u, v) = readln().split(' ').map { it.toInt() }

        nodes[u].edges.add(v)
        nodes[v].edges.add(u)
    }

    for (i in visited.indices) {
        if (i == 0 || visited[i] != Z) continue

        val ll = ArrayDeque<Int>()
        ll.add(i)
        visited[i] = O

        while (ll.isNotEmpty()) {
            val n = ll.removeFirst()

            for (m in nodes[n].edges) {
                if (visited[m] != Z) {
                    if (visited[m] == visited[n])
                        return@repeat println("NO")
                    continue
                }
                visited[m] = if (visited[n] == O) T else O

                ll.add(m)
            }
        }
    }

    println("YES")
}
