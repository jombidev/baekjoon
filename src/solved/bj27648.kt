fun main() {
    val (n, m, k) = readln().split(' ').map { it.toInt() }

    if (n + m - 1 > k) return print("NO")

    println("YES")

    val v = Array(n) { BooleanArray(m) }
    val a = Array(n) { IntArray(m) }

    val l = ArrayDeque<Triple<Int, Int, Int>>()
    l.add(Triple(0, 0, 1))
    a[0][0] = 1

    val dx = intArrayOf(1, 0)
    val dy = intArrayOf(0, 1)

    while (l.isNotEmpty()) {
        val (x, y, p) = l.removeFirst()

        for (i in 0..1) {
            val ox = x + dx[i]
            val oy = y + dy[i]

            if (ox !in 0..<m || oy !in 0..<n || v[oy][ox])
                continue

            v[oy][ox] = true
            a[oy][ox] = p + 1

            l.add(Triple(ox, oy, p + 1))
        }
    }

    print(a.joinToString("\n") { it.joinToString(" ") })
}
