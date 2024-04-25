package solved

fun main() {
    val n = List(readln().toInt()) { readln().split(' ').map { it.toInt() } }
    var (maxX, maxY) = List(2){-10001}
    var minX = Int.MAX_VALUE
    var minY = Int.MAX_VALUE
    for ((x, y) in n) {
        minX = minOf(x, minX)
        maxX = maxOf(x, maxX)
        minY = minOf(y, minY)
        maxY = maxOf(y, maxY)
    }
    print((maxX - minX) * (maxY - minY))
}