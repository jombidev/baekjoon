fun main() {
    data class T(val x: Int, val y: Int, val z: Int, val age: Int = 0)
    val (m, n, h) = readln().split(' ').map { it.toInt() }
    val tomatoes = java.util.LinkedList<T>()
    var zc = 0

    val b = Array(h) { z ->
        Array(n) { y ->
            val t = readln().split(' ').map { it.toInt() }.toIntArray()
            for ((x, i) in t.withIndex()) {
                if (i == 1) {
                    tomatoes.add(T(x, y, z))
                } else if (i == 0)
                    zc++
            }
            t
        }
    }
    if (zc == 0)
        return print(0)
    val v = Array(h) { Array(n) { BooleanArray(m) } }

    val vx = arrayOf(1, -1, 0, 0, 0, 0)
    val vy = arrayOf(0, 0, 1, -1, 0, 0)
    val vz = arrayOf(0, 0, 0, 0, 1, -1)
    var ssDay = 0

    while (tomatoes.isNotEmpty()) {
        val (x, y, z, a) = tomatoes.removeFirst()

        if (v[z][y][x])
            continue
        v[z][y][x] = true
        ssDay = maxOf(a, ssDay)

        for (i in 0..<6) {
            val ox = x + vx[i]
            val oy = y + vy[i]
            val oz = z + vz[i]

            if (ox !in 0..<m || oy !in 0..<n || oz !in 0..<h || v[oz][oy][ox] || b[oz][oy][ox] != 0)
                continue
            b[oz][oy][ox] = 1
            zc--

            tomatoes.add(T(ox, oy, oz, a + 1))
        }
    }
    println(if (zc != 0) -1 else ssDay)
}
