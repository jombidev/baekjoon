fun main() = repeat(readln().toInt()) {
    val n = readln().toInt()
    val c = readln().split(' ').map { it.toInt().let { if (it % 2 == 1) it + 1 else it } }.toIntArray()

    var cycle = 0

    while (c.distinct().size > 1) {
        c[c.lastIndex] /= 2
        val temp = c[c.lastIndex]

        for (i in n - 1 downTo 1) {
            val pi = (i - 1 + n) % n
            c[pi] /= 2
            c[i] += c[pi]
            c[i] += c[i] % 2
        }

        c[0] += temp
        c[0] += c[0] % 2

        cycle++
    }

    println(cycle)
}
