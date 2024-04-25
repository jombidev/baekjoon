package solved

fun main() {
    val (x, y, w, h) = readln().split(' ').map { it.toInt() }
    print(minOf(w - x, h - y, x, y))
}