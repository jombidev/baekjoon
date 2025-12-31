fun main() {
    val (a, b) = readln().split(' ').map { it.toDouble() }
    print((b * Math.log10(a) + 1).toInt())
}
