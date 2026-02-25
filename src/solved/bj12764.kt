import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val p = ArrayDeque(List(n) { readln().split(' ').map { it.toInt() } })

    p.sortBy { it[0] }

    val pq = PriorityQueue<List<Int>>(compareBy { it[1] })
    val mt = PriorityQueue<Int>()
    val sc = IntArray(n)
    var ms = 0

    while (p.isNotEmpty()) {
        val (cs, ce) = p.removeFirst()
        var pk = pq.peek()

        while (pk != null && pk[1] < cs) {
            pq.remove()
            mt.add(pk[2])

            pk = pq.peek()
        }

        val ts = mt.poll() ?: pq.size
        ms = maxOf(ms, ts + 1)
        sc[ts]++
        pq.add(listOf(cs, ce, ts))
    }

    println(ms)
    print(sc.take(ms).joinToString(" "))
}
