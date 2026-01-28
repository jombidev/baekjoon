import java.util.*

fun main() = repeat(readln().toInt()) {
    val l = readln().toInt()
    val a = 0..<l

    val v = Array(l) { BooleanArray(l) }

    val ll = LinkedList<IntArray>()
    ll.add((readln().split(' ').map { it.toInt() } + 0).toIntArray())

    val (tx, ty) = readln().split(' ').map { it.toInt() }
    val dx = intArrayOf(-2, -1, 1, 2, -2, -1, 1, 2)
    val dy = intArrayOf(1, 2, 2, 1, -1, -2, -2, -1)

    while (ll.isNotEmpty()) {
        val (x, y, c) = ll.removeFirst()

        if (tx == x && ty == y)
            return@repeat println(c)

        for (i in 0..<8) {
            val ox = x + dx[i]
            val oy = y + dy[i]

            if (ox !in a || oy !in a || v[oy][ox])
                continue

            v[oy][ox] = true

            ll.add(intArrayOf(ox, oy, c + 1))
        }
    }
}
