fun main() {
    val (_n, b) = readln().split(' ').map { it.toLong() }
    val n = _n.toInt()
    val bl = b.toString(2).length

    val a = Array(n) { LongArray(n) { i -> if (it == i) 1 else 0 } }
    val t = Array(n) { LongArray(n) }
    val m = Array(n) { LongArray(n) }

    repeat(n) {
        for ((i, value) in readln().split(' ').map { it.toLong() }.withIndex()) {
            m[it][i] = value
        }
    }

    fun mul(a: Array<LongArray>, b: Array<LongArray>) {
        for (i in 0..<n) for (j in 0..<n) t[i][j] = 0
        for (i in 0..<n) for (j in 0..<n) for (m in 0..<n) {
            t[i][j] += (a[i][m] * b[m][j]) % 1000
            t[i][j] = t[i][j] % 1000
        }
        for (i in 0..<n) for (j in 0..<n) a[i][j] = t[i][j]
    }

    if (b and 1 == 1L) {
        mul(a, m)
    }

    for (i in 1..<bl) {
        mul(m, m)
        if (b shr i and 1 == 1L)
            mul(a, m)
    }

    print(a.joinToString("\n") { it.joinToString(" ") })
}
