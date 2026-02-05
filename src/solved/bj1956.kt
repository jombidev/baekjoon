const val INF = 400 * 10000 + 1
fun main() {
    val (v, e) = readln().split(' ').map { it.toInt() }
    val edges = Array(v) { IntArray(v) { INF } }

    repeat(e) {
        val (a, b, p) = readln().split(' ').map { it.toInt() - 1 }
        edges[a][b] = p + 1
    }

    for (n in 0..<v)
        for (s in 0..<v)
            for (e in 0..<v)
                if (edges[s][e] > edges[s][n] + edges[n][e])
                    edges[s][e] = edges[s][n] + edges[n][e]

    var c = INF

    for (i in 0..<v) {
        for (j in 0..<v) {
            if (i != j && edges[i][j] != INF && edges[j][i] != INF)
                c = minOf(c, edges[i][j] + edges[j][i])
        }
    }

    print(if (c == INF) -1 else c)
}
