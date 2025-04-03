fun main() {
    val (K, N) = readln().split(' ').map { it.toLong() }
    val m = List(K.toInt()) { readln().toLong() }
    var high = m.max()
    var low = high / N

    while (low <= high) {
        val mid = (low + high).ushr(1)

        val cmp = N - m.sumOf { it / maxOf(mid, 1) }

        if (cmp < 0)
            low = mid + 1
        else if (cmp > 0)
            high = mid - 1
        else break
    }

    for (i in high downTo low) {
        if (m.sumOf { it / i } == N) {
            return print(i)
        }
    }
    print(high)
}
