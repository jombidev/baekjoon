import java.util.LinkedList
import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val f = Array(n) { IntArray(n) }

    var s = 0 to 0
    var sz = 2
    val fs = HashMap<Pair<Int, Int>, Int>()

    val mx = arrayOf(0, -1, 1, 0)
    val my = arrayOf(-1, 0, 0, 1)

    repeat(n) {
        for ((i, v) in readln().split(' ').map { it.toInt() }.withIndex()) {
            f[it][i] = v % 9
            if (v == 9)
                s = i to it
            else if (v > 0)
                fs[i to it] = v
        }
    }

    var ec = 0
    var tt = 0

    while (true) {
        if (fs.isEmpty())
            break

        if (fs.values.none { it < sz })
            break

        val ll = LinkedList<Triple<Int, Int, Int>>()
        val pq = PriorityQueue(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first })
        val v = Array(n) { BooleanArray(n) }
        var me = Int.MAX_VALUE
        ll.add(Triple(s.first, s.second, 0))
        while (ll.isNotEmpty()) {
            val (x, y, t) = ll.removeFirst()

            if (v[y][x])
                continue
            v[y][x] = true

            if (f[y][x] in 1..<sz) { // eatable
                me = minOf(me, t)
                if (me < t)
                    break
                pq.add(x to y)
            }

            for (i in 0..<4) {
                val ox = x + mx[i]
                val oy = y + my[i]

                if (ox !in 0..<n || oy !in 0..<n || v[oy][ox] || f[oy][ox] > sz)
                    continue

                ll.add(Triple(ox, oy, t + 1))
            }
        }

        if (pq.isNotEmpty()) {
            val (x, y) = pq.remove()
            s = x to y
            ec++
            if (ec == sz) {
                ec = 0
                sz++
            }
            f[y][x] = 0
            tt += me
            fs.remove(x to y)
        } else break
    }

    print(tt)
}
