fun main() {
    val size = readln().toInt()
    val rgb = List(size) { readln().split(' ').map { it.toInt() } }
    val DP = Array(size) { Array(3) { 0 } }
    rgb[0].let { (r, g, b) -> DP[0][0] = r;DP[0][1] = g;DP[0][2] = b }

    for ((i, thing) in rgb.withIndex()) {
        if (i == 0) continue
        val (r, g, b) = DP[i - 1]

        DP[i][0] = minOf(g, b) + thing[0]
        DP[i][1] = minOf(r, b) + thing[1]
        DP[i][2] = minOf(r, g) + thing[2]
    }

    print(DP.last().min())
}
