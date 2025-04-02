fun main() {
    val (n, k) = readln().split(' ').map { it.toInt() }
    println(factorial(n) / (factorial(k) * factorial(n - k)))
}

fun factorial(d: Int) = List(d) { it + 1 }.reduceOrNull(Int::times) ?: 1
