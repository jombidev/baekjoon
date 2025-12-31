import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val y = readln().split(' ').map { it.toDouble() }
    val p = Array(3) { readln().split(' ').map { it.toDouble() } }

    fun d(a: List<Double>, b: List<Double>) = sqrt((b[0] - a[0]).pow(2) + (b[1] - a[1]).pow(2))

    var min = Double.MAX_VALUE
    for (i in p) {
        for (j in p) {
            for (k in p) {
                if (i == j || j == k || k == i) continue
                min = minOf(min, d(y, i) + d(i, j) + d(j, k))
            }
        }
    }

    print(min.toInt())
}
