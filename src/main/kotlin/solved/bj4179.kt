package solved

import java.util.*

fun main() {
    val (R, C) = readln().split(' ').map { it.toInt() }
    val xPath = listOf(1, -1, 0, 0)
    val yPath = listOf(0, 0, 1, -1)
    val visited = Array(R) { Array(C) { false } }
    val field = Array(R) {
        readln().split("").filter { it.isNotBlank() }
            .mapIndexed { i, j -> P(j[0], L(i, it), 0) }
            .toTypedArray()
    }
    val fin = arrayListOf<Int>()
    val list = LinkedList(s(field, 'F') + f(field, 'J'))
    while (list.isNotEmpty()) {
        val (c, l, v) = list.removeFirst()
        val (x, y) = l

        for (z in 0..3) {
            val fX = x + xPath[z]
            val fY = y + yPath[z]

            if ((c == 'J' || c == 'j') && (x == 0 || x == C - 1 || y == 0 || y == R - 1)) fin.add(v + 1)
            if (fX !in 0 until C || fY !in 0 until R) continue

            val p = L(fX, fY)
            if (c == 'J' || c == 'j') {
                val f = field[fY][fX]

                if (f.c == 'F' || visited[fY][fX]) continue
                if (f.c == '.') {
                    if (c == 'J') field[y][x] = P('.', l, 0)
                    visited[fY][fX] = true
                    list.addLast(P('j', p, v + 1))
                }
            }
            if (c == 'F') {
                val f = field[fY][fX]
                if (f.c == '.') {
                    val el = P('F', p, 0)
                    field[fY][fX] = el
                    list.addLast(el)
                }
            }
        }
    }
    print(if (fin.isEmpty()) "IMPOSSIBLE" else fin.min())
}

fun f(l: Array<Array<P>>, e: Char) = l.firstNotNullOf { it.find { it.c == e } }
fun s(l: Array<Array<P>>, e: Char): List<P> {
    val s = arrayListOf<P>()
    for (ps in l) for (p in ps) s.add(p)
    return s.filter { it.c == e }
}
data class L(val x: Int, val y: Int)
data class P(val c: Char, val l: L, val v: Int)