import java.util.*

fun main() {
    val n = readln().toInt()
    val pq = PriorityQueue<Int>()

    repeat(n) {
        val st = StringTokenizer(readln(), " ")

        while (st.hasMoreTokens()) {
            pq.add(st.nextToken().toInt())
            if (pq.size > n)
                pq.remove()
        }
    }

    print(pq.remove())
}
