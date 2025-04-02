fun main() {
    val (n, m) = readln().ints()
    val o = Array(n) { readln().ints().toTypedArray() }
    val v = Array(n) { Array(m) { false } }
    val work = ArrayDeque<Pair<Int, Int>>()

    for ((i, scan) in o.withIndex()) {
        for ((j, value) in scan.withIndex()) {
            if (value == 1) work.add(i to j)
        }
    }


    var paintCount = 0
    var maxSz = 0

    while (work.isNotEmpty()) {
        val did = dfs(work, work.removeLast(), o, v, n, m)
        if (did > 0) {
            paintCount++
            maxSz = maxOf(maxSz, did)
        }
    }

    print("$paintCount\n$maxSz")
}

private val offX = arrayOf(1, -1, 0, 0)
private val offY = arrayOf(0, 0, 1, -1)

private fun dfs(work: MutableList<Pair<Int, Int>>, value: Pair<Int, Int>, o: Array<Array<Int>>, v: Array<Array<Boolean>>, n: Int, m: Int): Int {
    val (x, y) = value
    if (v[x][y]) return -1
    v[x][y] = true

    var count = o[x][y]
    for (i in 0 ..< 4) {
        val px = x + offX[i]
        val py = y + offY[i]
        if (px !in 0..< n || py !in 0..< m) continue

        if (o[px][py] == 1 && !v[px][py]) {
            count += dfs(work, px to py, o, v, n, m)
        }
    }
    return count
}

private fun String.ints() = split(' ').map { it.toInt() }
