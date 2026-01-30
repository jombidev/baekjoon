fun main() = repeat(readln().toInt()) {
    val (k, n) = readln().split(' ').map { it.toInt() }
    println("$k ${(n * (n + 1)).ushr(1) + n}")
}
