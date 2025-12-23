fun main() = System.`in`.bufferedReader().use {
    val (n, m, x) = it.readLine().split(' ').map { it.toInt() }

    val nodes = Array(n + 1) { IntArray(n + 1) { Int.MAX_VALUE } }

    for (i in 1..n)
        nodes[i][i] = 0

    repeat(m) { _ ->
        val (s, e, t) = it.readLine().split(' ').map { it.toInt() }

        nodes[s][e] = t
    }

    for (o in 1..n)
        for (i in 1..n)
            for (j in 1..n)
                if (nodes[i][o] != Int.MAX_VALUE && nodes[o][j] != Int.MAX_VALUE)
                    nodes[i][j] = minOf(nodes[i][j], nodes[i][o] + nodes[o][j])

    print((1..n).maxOf { nodes[it][x] + nodes[x][it] })
}
