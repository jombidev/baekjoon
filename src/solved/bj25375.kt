fun main() = repeat(readln().toInt()) {
    val (a, b) = readln().split(' ').map { it.toLong() }
    println(if (b % a != 0L || b / a == 1L) 0 else 1)
}
