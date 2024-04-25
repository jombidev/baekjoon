package solved

fun main() {
    while (true) {
        val n = readln().split(' ').map { it.toInt() }
        val m = n.max()
        if (m == 0) return
        println(
            if (n.sum() - m <= m) "Invalid"
            else {
                val l = n.toSet()
                when (l.size) {
                    1 -> "Equilateral"
                    3 -> "Scalene"
                    else -> "Isosceles"
                }
            }
        )
    }
}