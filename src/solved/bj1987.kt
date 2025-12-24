fun main() {
    val (r, c) = readln().split(' ').map { it.toInt() }
    val a = Array(r) { CharArray(c) }

    repeat(r) {
        for ((i, v) in readln().withIndex()) a[it][i] = v
    }

    val s = HashSet<Char>()
    val ox = arrayOf(1, -1, 0, 0)
    val oy = arrayOf(0, 0, 1, -1)

    val v = Array(r) { BooleanArray(c) }
    var ml = 1

    fun dfs(x: Int, y: Int) {
        if (s.contains(a[y][x])) {
            ml = maxOf(ml, s.size)
            return
        }
        s.add(a[y][x])

        for (i in 0..<4) {
            val dx = x + ox[i]
            val dy = y + oy[i]

            if (dx !in 0..<c || dy !in 0..<r || v[dy][dx])
                continue

            v[dy][dx] = true
            dfs(dx, dy)
            v[dy][dx] = false
        }

        ml = maxOf(ml, s.size)

        s.remove(a[y][x])
    }

    dfs(0, 0)
    print(ml)
}
