import java.util.LinkedList

fun main() = System.`in`.bufferedReader().use { r ->
    repeat(r.readLine().toInt()) {
        val (n, m, w) = r.readLine().split(' ').map { it.toInt() }

        val edges = LinkedList<Triple<Int, Int, Int>>()
        val distance = IntArray(n + 1) { 5000001 }
        distance[1] = 0

        repeat(m) {
            val (s, e, t) = r.readLine().split(' ').map { it.toInt() }
            edges.add(Triple(s, e, t))
            edges.add(Triple(e, s, t))
        }
        repeat(w) {
            val (s, e, t) = r.readLine().split(' ').map { it.toInt() }
            edges.add(Triple(s, e, -t))
        }

        repeat(n) {
            for ((s, e, t) in edges)
                distance[e] = minOf(distance[e], distance[s] + t)
        }

        for ((s, e, t) in edges)
            if (distance[e] > distance[s] + t)
                return@repeat println("YES")
        println("NO")
    }
}
