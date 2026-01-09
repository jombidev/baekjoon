import java.io.File
import kotlin.math.abs

fun main() {
    val (r1, c1, r2, c2) = readln().split(' ').map { it.toInt() }

    val h = r2 - r1
    val w = c2 - c1

    val ts = maxOf(abs(r1), abs(r2), abs(c1), abs(c2))

    val m = Array(h + 1) { IntArray(w + 1) }

    val sx = intArrayOf(0, -1, 0, 1)
    val sy = intArrayOf(-1, 0, 1, 0)
    var x = 0
    var y = 0
    var b = 0
    var a = 0
    var i = 0

    while (true) {
        i++

        val ox = x - c1
        val oy = y - r1

        if (ox in 0..w && oy in 0..h)
            m[oy][ox] = i

        if (i == 1) {
            x = 1
            y = 0
            b++
        } else {
            if (a < 4) {
                x += sx[a]
                y += sy[a]
            } else {
                x += 1
            }
            when (a) {
                0 -> if (y == -b) a++
                1 -> if (x == -b) a++
                2 -> if (y == b) a++
                3 -> if (x == b) {
                    a++
                    b++
                }
                4 -> {
                    a = 0
                    if (b > ts)
                        break
                }
            }
        }
    }

    val ml = m.maxOf { it.max() }.toString().length
    print(m.joinToString("\n") { it.joinToString(" ") { it.toString().padStart(ml, ' ') } })
}
