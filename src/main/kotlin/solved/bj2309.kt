package solved

fun main() {
    val m = List(9){readln().toInt()}
    for (i in 0..<9)
        for (j in 0..<9) {
            if (i == j) continue
            var s = 0
            for (k in 0..<9) {
                if (k == i || k == j) continue
                s+=m[k]
            }
            if (s==100)
                return println(m.filter { !listOf(m[i], m[j]).contains(it) }.sorted().joinToString("\n"))
        }
}
