fun main() {
    fun matrix(y: Int, x: Int): Array<IntArray> {
        val a = Array(y) { IntArray(x) }

        repeat(y) {
            val st = java.util.StringTokenizer(readln(), " ")
            var i = 0
            while (st.hasMoreTokens()) {
                a[it][i++] = st.nextToken().toInt()
            }
        }

        return a
    }

    val (n, m) = readln().split(' ').map { it.toInt() }
    val a = matrix(n, m)

    val (_, k) = readln().split(' ').map { it.toInt() }
    val b = matrix(m, k)

    val t = Array(n) { IntArray(k) }

    for (i in 0..<n) for (j in 0..<k) for (m in 0..<m)
        t[i][j] += a[i][m] * b[m][j]

    print(t.joinToString("\n") { it.joinToString(" ") })
}
