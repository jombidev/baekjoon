import java.util.*

fun main() = System.`in`.bufferedReader().use {
    fun readln() = it.readLine()

    val (n, k) = readln().split(' ').map { it.toInt() }
    val mv = Array(n) { readln().split(' ').map { it.toInt() }.toIntArray() }
    val c = IntArray(k) { readln().toInt() }

    mv.sortBy { it[0] }
    c.sort()

    var value = 0L
    val pq = PriorityQueue<Int>(reverseOrder())
    var off = 0

    for (i in c.indices) {
        while (off < n) {
            if (c[i] >= mv[off][0]) {
                pq.offer(mv[off++][1])
            } else break
        }

        value += pq.poll() ?: 0
    }

    print(value)
}
