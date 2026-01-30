fun main() {
    val (a, b, c) = readln().split(' ').map { it.toInt() }
    val t = maxOf(0, readln().toInt() - 30)

    print(a + (t + b - 1) / b * c)
}
