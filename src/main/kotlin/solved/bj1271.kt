package solved

fun main() {
    val (n, m) = readln().split(' ').map { it.toBigInteger() }
    print("${n / m} ${n % m}")
}