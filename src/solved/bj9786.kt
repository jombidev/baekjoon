fun main() = repeat(readln().toInt()) {
    val (a, b) = readln().split(' ').map { it.toInt() }
    val c = gcd(a, b)
    println("${a / c} ${b / c}")
}

fun gcd(a: Int, b: Int): Int {
    if (b == 0) return a
    return gcd(b, a % b)
}
