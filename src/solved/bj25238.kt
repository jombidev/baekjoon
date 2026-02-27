fun main() {
    val (a, b) = readln().split(' ').map { it.toDouble() }
    print(if (a - a * b / 100 < 100) 1 else 0)
}
