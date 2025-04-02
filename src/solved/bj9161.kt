fun main() {
    val e = listOf(111,222,333,444,555,666,777,888,999)
    for (i in 100..999) {
        if (i in e) continue
        val l = i % 10 * 100
        for (j in l..l + 99) {
            if (j == 0 || j in e) continue
            val m = i / 10
            val n = j % 100
            if (m.toDouble() / n == i.toDouble() / j) {
                println("$i / $j = $m / $n")
            }
        }
    }
}
