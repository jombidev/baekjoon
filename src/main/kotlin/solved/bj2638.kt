package solved

var edgeX = 0
var edgeY = 0
fun main() {
    val (X, Y) = readln().split(' ').map { it.toInt() }
    edgeX = X
    edgeY = Y
    val cheeses =
        Array(X) { readln().split(' ').map { it.toInt() }.mapIndexed { i, j -> arrayOf(j, i, it) }.toTypedArray() }
    var days = 0
    while (cheeses.flatten().any { it[0] == 1 }) {
        println(cheeses.joinToString("\n") { it.joinToString(" ") { "${it[0]}" } })
        println()

        melt(cheeses)
        ++days
    }
    print(days)
}

fun isEdge(x: Int, y: Int) = x == 0 || x == edgeX - 1 || y == 0 || y == edgeY - 1
val xPath = listOf(1, -1, 0, 0)
val yPath = listOf(0, 0, 1, -1)

fun melt(a: Array<Array<Array<Int>>>) {
    val deq = ArrayDeque(a.flatten().filter { it[0] == 0 && isEdge(it[1], it[2]) })
    val visited = Array(edgeX) { Array(edgeY) { false } }
    val cheeses = ArrayDeque<Array<Int>>()
    while (deq.isNotEmpty()) {
        val (_, x, y) = deq.removeFirst()

        for (z in xPath.indices) {
            val xp = x + xPath[z]
            val yp = y + yPath[z]
            if (xp !in 0 until edgeY || yp !in 0 until edgeX || a[yp][xp][0] == 0 && visited[yp][xp]) continue
            val e = a[yp][xp]
            visited[yp][xp] = true
            (if (e[0] == 1) cheeses else deq).addLast(e)
        }
    }

    for ((_, x, y) in cheeses.filter { cheeses.count { c -> c.contentEquals(it) } >= 2 }.toSet()) a[y][x][0] = 0
}