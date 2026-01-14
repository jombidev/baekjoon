import kotlin.math.abs
import kotlin.math.sin

fun main() {
    val (a, b, c) = readln().split(' ').map { it.toDouble() }

    fun bsearch(l: Double, r: Double): Double {
        val m = l + (r - l) / 2.0

        val res = a * m + b * sin(m)

        return if (abs(c - res) <= 0.1e-9) {
            m
        } else {
            when (res.compareTo(c)) {
                1 -> bsearch(l, m)
                -1 -> bsearch(m, r)
                else -> bsearch(l, r)
            }
        }
    }

    println(bsearch(.0, c * 2))
}
