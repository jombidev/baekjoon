fun main() {
    fun r() = readln().split(' ').map { it.toDouble() }
    val (hlo, hhi) = r()
    val (slo, shi) = r()
    val (vlo, vhi) = r()
    val rgb = r()

    val M = rgb.max()
    val m = rgb.min()

    val (r, g, b) = rgb

    val v = M
    val s = 255 * ((v - m) / v)
    val h = when (v) {
        r -> (60 * (g - b)) / (v - m)
        g -> 120 + (60 * (b - r)) / (v - m)
        else/*b*/ -> 240 + (60 * (r - g)) / (v - m)
    }.let { if (it < 0) 360 + it else it }

    val o = if (h in hlo..hhi && s in slo..shi && v in vlo..vhi) " " else " not "

    print("Lumi will${o}like it.")
}
