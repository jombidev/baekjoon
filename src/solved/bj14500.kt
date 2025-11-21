fun main() {
    val minos = arrayOf(
        // I
        arrayOf(
            arrayOf(1, 1, 1, 1)
        ),
        arrayOf(
            arrayOf(1),
            arrayOf(1),
            arrayOf(1),
            arrayOf(1)
        ),
        // L, J
        arrayOf(
            arrayOf(1, 1, 1),
            arrayOf(1, 0, 0)
        ),
        arrayOf(
            arrayOf(0, 0, 1),
            arrayOf(1, 1, 1),
        ),
        arrayOf(
            arrayOf(1, 0, 0),
            arrayOf(1, 1, 1)
        ),
        arrayOf(
            arrayOf(1, 1, 1),
            arrayOf(0, 0, 1),
        ),
        arrayOf(
            arrayOf(1, 0),
            arrayOf(1, 0),
            arrayOf(1, 1)
        ),
        arrayOf(
            arrayOf(1, 1),
            arrayOf(0, 1),
            arrayOf(0, 1)
        ),
        arrayOf(
            arrayOf(0, 1),
            arrayOf(0, 1),
            arrayOf(1, 1)
        ),
        arrayOf(
            arrayOf(1, 1),
            arrayOf(1, 0),
            arrayOf(1, 0)
        ),
        // S, Z
        arrayOf(
            arrayOf(1, 0),
            arrayOf(1, 1),
            arrayOf(0, 1),
        ),
        arrayOf(
            arrayOf(0, 1),
            arrayOf(1, 1),
            arrayOf(1, 0),
        ),
        arrayOf(
            arrayOf(1, 1, 0),
            arrayOf(0, 1, 1),
        ),
        arrayOf(
            arrayOf(0, 1, 1),
            arrayOf(1, 1, 0),
        ),
        // T
        arrayOf(
            arrayOf(1, 1, 1),
            arrayOf(0, 1, 0),
        ),
        arrayOf(
            arrayOf(0, 1, 0),
            arrayOf(1, 1, 1),
        ),
        arrayOf(
            arrayOf(1, 0),
            arrayOf(1, 1),
            arrayOf(1, 0),
        ),
        arrayOf(
            arrayOf(0, 1),
            arrayOf(1, 1),
            arrayOf(0, 1),
        ),
        // O
        arrayOf(
            arrayOf(1, 1),
            arrayOf(1, 1),
        )
    )
    val (n, m) = readln().split(' ').map { it.toInt() }
    val a = Array(n) { readln().split(' ').map { it.toInt() }.toIntArray() }

    var max = 0
    val yr = 0..<n
    val xr = 0..<m
    for (y in yr) {
        for (x in xr) {
            nm@for (m in minos) {
                var sum = 0
                for (minoY in m.indices) {
                    for (minoX in m[minoY].indices) {
                        val ox = x + minoX
                        val oy = y + minoY
                        if (ox !in xr || oy !in yr)
                            continue@nm
                        if (m[minoY][minoX] == 0)
                            continue

                        sum += a[oy][ox]
                    }
                }
                max = maxOf(sum, max)
            }
        }
    }
    print(max)
}
