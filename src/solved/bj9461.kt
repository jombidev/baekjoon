fun main() {
    val t = List(readln().toInt()) { readln().toInt() }
    val n = t.max()
    val DP = Array(n + 5) { 0L }
    listOf(0L, 1, 1, 1, 2, 2).forEachIndexed { i, it -> DP[i] = it }

    for (i in 5..n)
        DP[i] = DP[i - 5] + DP[i - 1]

    t.map { DP[it] }.forEach(::println)
}
