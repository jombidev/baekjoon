fun main() {
    val omok = Array(10) { readln().toCharArray() }

    val ox = intArrayOf(1, 0, 1, -1)
    val oy = intArrayOf(0, 1, 1, 1)

    for (i in 0..9)
    for (j in 0..9) {
        if (omok[i][j] != '.')
            continue

        omok[i][j] = 'X'

        for (y in 0..9)
        for (x in 0..9)
        for (n in 0..3) {
            var hit = 0

            for (mv in 0..4) {
                val dx = x + ox[n] * mv
                val dy = y + oy[n] * mv

                if (dx !in 0..9 || dy !in 0..9 || omok[dy][dx] != 'X') break
                hit++
            }

            if (hit >= 5)
                return print(1)
        }

        omok[i][j] = '.'
    }

    print(0)
}
