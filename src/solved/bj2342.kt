fun main() {
    val task = readln().split(' ').map { it.toInt() }

    val offset = arrayOf(
        intArrayOf(0, 2, 2, 2, 2),
        intArrayOf(0, 1, 3, 4, 3),
        intArrayOf(0, 3, 1, 3, 4),
        intArrayOf(0, 4, 3, 1, 3),
        intArrayOf(0, 3, 4, 3, 1),
    )
    val mem = Array(5) { Array(5) { IntArray(task.size) { -1 } } }

    fun step(l: Int, r: Int, index: Int): Int {
        if (index == task.size) return 0
        if (mem[l][r][index] == -1) {
            val move = minOf(
                step(task[index], r, index + 1) + offset[l][task[index]],
                step(l, task[index], index + 1) + offset[r][task[index]]
            )

            mem[l][r][index] = move
        }
        return mem[l][r][index]
    }

    val result = step(0, 0, 0)

    print(result)
}
