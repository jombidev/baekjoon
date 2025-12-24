fun main() {
    val (r, c, t) = readln().split(' ').map { it.toInt() }

    val room = Array(r) { IntArray(c) }
    val ac = Array(2) { -1 to -1 }
    var acl = 0

    val ox = arrayOf(1, -1, 0, 0)
    val oy = arrayOf(0, 0, 1, -1)

    val acm = arrayOf(
        arrayOf(
            arrayOf(0, -1),
            arrayOf(1, 0),
            arrayOf(0, 1),
            arrayOf(-1, 0),
        ),
        arrayOf(
            arrayOf(0, 1),
            arrayOf(1, 0),
            arrayOf(0, -1),
            arrayOf(-1, 0),
        )
    )

    repeat(r) {
        for ((i, value) in readln().split(' ').map { it.toInt() }.withIndex()) {
            room[it][i] = value

            if (value == -1)
                ac[acl++] = i to it
        }
    }

    var gen = 0

    while (gen++ < t) {
        val dusts = room.flatMapIndexed { y, it ->
            it.mapIndexed { x, it -> if (it > 0) Triple(x, y, it) else null }.filterNotNull()
        }

        for ((x, y, num) in dusts) {
            var dustMod = 0

            for (i in 0..3) {
                val dx = x + ox[i]
                val dy = y + oy[i]

                if (dx !in 0..<c || dy !in 0..<r || room[dy][dx] == -1)
                    continue

                dustMod++

                room[dy][dx] += num / 5
            }

            room[y][x] -= num / 5 * dustMod
        }
        for ((i, acp) in ac.withIndex()) {
            val (x, y) = acp
            var (mx, my) = acp
            var state = 0

            while (state < 3 || x != mx || y != my) {
                val ox = acm[i][state][0]
                val oy = acm[i][state][1]

                if (mx + ox !in 0..<c || my + oy !in (if (i == 0) 0..y else y..<r)) {
                    state++
                    continue
                }

                if (mx + ox != x || my + oy != y) {
                    val dust = room[my + oy][mx + ox]
                    if (room[my][mx] != -1) {
                        room[my][mx] = dust
                    }
                    room[my + oy][mx + ox] = 0
                }

                mx += ox
                my += oy
            }
        }
    }

    print(room.sumOf { it.sumOf { if (it > 0) it else 0 } })
}
