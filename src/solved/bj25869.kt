fun main() {
    val (w, h, d) = readln().split(' ').map { it.toInt() }
    print(maxOf(0, w - d * 2) * maxOf(0, h - d * 2))
}
