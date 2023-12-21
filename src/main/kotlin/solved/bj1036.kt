package solved

fun main() {
    val flatten = List(readln().toInt()) { readln().toCharArray() }
    var r = readln().toInt()
    while (r > 0) {
        val m = flatten.sortedByDescending { it.size + 1.0 / it.joinToString("").toLong(36) }
        while (true) {

            val e = m.firstOrNull { it.none { it != 'Z' } } ?: break
            e[e.indexOfFirst { it != 'Z' }] = 'Z'
            break
        }
        r--
    }
    println(flatten.map { it.joinToString("") })
    println(flatten.sumOf { it.joinToString("").toBigInteger(36) }.toString(36))
}