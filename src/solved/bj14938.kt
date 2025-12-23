fun main() {
    val (n, m, r) = readln().split(' ').map { it.toInt() }
    val t = readln().split(' ').map { it.toInt() }

    val ls = Array(n + 1) { IntArray(n + 1) { Int.MAX_VALUE } }
    for (i in 1..n)
        ls[i][i] = 0

    repeat(r) {
        val (x, y, l) = readln().split(' ').map { it.toInt() }
        ls[x][y] = l
        ls[y][x] = l
    }

    for (o in 1..n)
        for (i in 1..n)
            for (j in 1..n)
                if (ls[i][o] != Int.MAX_VALUE && ls[o][j] != Int.MAX_VALUE)
                    ls[i][j] = minOf(ls[i][j], ls[i][o] + ls[o][j])


    print(
        (1..n).maxOf {
            var c = 0
            for (j in 1..n) {
                if (ls[it][j] > m) continue
                c += t[j - 1]
            }
            c
        }
    )
}
