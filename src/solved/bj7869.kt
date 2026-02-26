import kotlin.math.*

fun main() {
    val _f = readln().split(' ').map { it.toDouble() }
    val (x1, y1, r1, x2, y2) = _f
    val r2 = _f[5]

    val dsq = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)
    val d = sqrt(dsq)
    val r1sq = r1 * r1
    val r2sq = r2 * r2
    fun angle(w1: Double, w2: Double) = acos((-(w1 * w1) + (w2 * w2) + dsq) / (2 * w2 * d))

    print(
        "%.3f".format(
            when {
                r1 + r2 <= d -> .0
                abs(r2 - r1) >= d -> PI * minOf(r1, r2) * minOf(r1, r2)
                else -> {
                    val a1 = angle(r2, r1) * 2
                    val a2 = angle(r1, r2) * 2

                    (r1sq * a1 + r2sq * a2 - r1sq * sin(a1) - r2sq * sin(a2)) / 2
                }
            }
        )
    )
}
