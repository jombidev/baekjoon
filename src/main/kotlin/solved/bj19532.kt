fun main() {
    val m = readln().split(' ').map { it.toInt() }
    val (a, b, c, d, e) = m
    val f = m[5]
    for (x in -999..999) {
        for (y in -999 .. 999) {
            if (a * x + b * y == c && d * x + e * y == f) {
                return print("$x $y")
            }
        }
    }
}
