fun main() = repeat(readln().toInt()) {
    val points = Array(4) { readln().split(' ').map { it.toInt() } }
    points.sortWith(compareBy<List<Int>> { it[0] }.thenBy { it[1] })

    fun pow2(n: Int) = n * n
    fun dist(a: List<Int>, b: List<Int>) = kotlin.math.sqrt(.0 + pow2(b[0] - a[0]) + pow2(b[1] - a[1]))

    val straight = setOf(
        dist(points[0], points[1]),
        dist(points[1], points[3]),
        dist(points[3], points[2]),
        dist(points[2], points[0]),
    ).size == 1
    val diag = setOf(
        dist(points[0], points[3]),
        dist(points[1], points[2]),
    ).size == 1

    println(if (straight && diag) 1 else 0)
}
