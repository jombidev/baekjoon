fun main() {
    val n = readln().toInt()
    val s = Array(n) { readln().split(' ').map { it.toInt() }.toIntArray() }

    for (i in 1..<n) {
        for (j in 0..i) {
            when (j) {
                0 -> s[i][0] += s[i - 1][0]
                i -> s[i][j] += s[i - 1][j - 1]
                else -> s[i][j] += maxOf(s[i - 1][j - 1], s[i - 1][j])
            }
        }
    }
    print(s.last().max())
}
