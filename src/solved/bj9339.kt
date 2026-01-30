import java.util.PriorityQueue

fun main() = repeat(readln().toInt()) {
    readln()
    val c = readln().trim().split(' ').map { it.toInt() }
    val pq = PriorityQueue(compareBy<IntArray> { it[1] }.thenBy { it[2] }.thenBy { it[3] })

    for (i in 0..<readln().toInt()) {
        val (nc, h, m) = readln().trim().split(' ').map { it.toInt() }
        if (h == m && m == -1 || nc !in c || h == 6 && m > 0 || h > 6) continue
        pq.add(intArrayOf(nc, h, m, i))
    }

    println("${pq.remove()[0]} ${pq.size + 1}")
}
