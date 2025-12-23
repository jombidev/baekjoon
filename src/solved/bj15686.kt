import java.util.LinkedList

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }

    val u = LinkedList<Pair<Int, Int>>()
    val ch = LinkedList<Pair<Int, Int>>()

    repeat(n) {
        for ((i, v) in readln().split(' ').map { it.toInt() }.withIndex()) {
            if (v == 1)
                u.add(it to i)
            else if (v == 2)
                ch.add(it to i)
        }
    }

    val combos = LinkedList<List<Pair<Int, Int>>>()
    val combo = Array(m) { 0 to 0 }

    fun combination(i: Int = 0, d: Int = 0) {
        if (d == m) {
            combos.add(combo.toList())
            return
        }

        for (j in i..<ch.size) {
            combo[d] = ch[j]
            combination(j + 1, d + 1)
        }
    }

    combination()

    print(
        combos.minOf {
            u.sumOf { (x1, y1) ->
                it.minOf { (x2, y2) -> Math.abs(x1 - x2) + Math.abs(y1 - y2) }
            }
        }
    )
}
