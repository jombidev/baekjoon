fun main() {
    val s = Array(9) { readln().split(' ').map { it.toInt() }.toTypedArray() }

    s.bt(0, 0)

    for (m in s)
        println(m.joinToString(" "))
}

fun Array<Array<Int>>.placeable(x: Int, y: Int, n: Int): Boolean {
    for (i in indices) {
        if (this[y][i] == n) return false
        if (this[i][x] == n) return false
    }
    for (yy in 0..<3) {
        for (xx in 0..<3) {
            if (this[y / 3 * 3 + yy][x / 3 * 3 + xx] == n) return false
        }
    }

    return true
}

fun Array<Array<Int>>.bt(x: Int, y: Int): Boolean {
    if (x == 9) {
        if (y == 8)
            return true
        return bt(0, y + 1)
    }

    if (this[y][x] != 0)
        return bt(x + 1, y)

    for (n in 1..9) {
        if (!placeable(x, y, n))
            continue

        this[y][x] = n
        if (bt(x + 1, y))
            return true
        this[y][x] = 0
    }

    return false
}
