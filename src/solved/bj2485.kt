fun main() {
    val t = List(readln().toInt()) {readln().toLong()}
    val m = t[0]
    val gcd = t.map { it - m }.reduce { a, b -> gcd(a, b) }

    var i = 0
    var s = 0L
    while (i < t.lastIndex) {
        s += (t[i + 1] - t[i]) / gcd - 1
        i++
    }
    print(s)
}

fun gcd(a: Long, b: Long): Long {
    val r = a % b
    if (r == 0L) return b
    return gcd(b, r)
}
