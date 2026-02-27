fun main() = System.`in`.bufferedReader().use {
    fun r() = it.readLine()

    val n = r().toInt()
    val abcd = Array(4) { IntArray(n) }
    val ab = IntArray(n * n)
    val cd = DoubleArray(n * n)

    repeat(n) {
        for ((i, v) in r().split(' ').map { it.toInt() }.withIndex())
            abcd[i][it] = v
    }

    for (i in 0..<n) {
        for (j in 0..<n) {
            ab[i * n + j] = abcd[0][i] + abcd[1][j]
            cd[i * n + j] = (-abcd[2][i] - abcd[3][j]).toDouble()
        }
    }

    cd.sort()
    var sum = 0L

    for (i in ab) {
        val l = -(cd.binarySearch(i - 0.5) + 1)
        val r = -(cd.binarySearch(i + 0.5) + 1)

        if (l < r)
            sum += r - l
    }

    print(sum)
}
