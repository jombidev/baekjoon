fun main() {
    val (y, x) = readln().split(' ').map { it.toInt() }
    val checker = List(y) { readln().toCharArray() }
    val wb = listOf("WBWBWBWB", "BWBWBWBW")

    var min = Int.MAX_VALUE

    for (i in 0..y - 8) {
        for (j in 0..x - 8) {
            for (c in 0..1) {
                var wc = 0
                for (yy in 0..<8) {
                    val m = wb[(yy + c) % 2]
                    for ((xx, h) in m.withIndex()) {
                        if (checker[i + yy][j + xx] != h) {
                            wc++
                        }
                    }
                }
                min = minOf(wc, min)
                if (min == 0) break
            }
        }
    }
    print(min)
}
