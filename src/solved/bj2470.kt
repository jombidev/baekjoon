fun main() {
    val n = readln().toInt()
    val q = readln().split(' ').map { it.toLong() }.sorted()
    val pq = java.util.PriorityQueue<Triple<Long, Long, Long>>(compareBy { Math.abs(it.first) })

    var l = 0
    var r = n - 1

    while (l < r) {
        val tg = q[l] + q[r]
        pq.add(Triple(tg, q[l], q[r]))
        if (tg > 0) {
            r--
        } else if (tg < 0) {
            l++
        } else break // zero exists
    }

    val (best, dx, dy) = pq.poll()
    print("$dx $dy")
}
