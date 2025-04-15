fun main() {
    val pq = java.util.PriorityQueue<Int>(reverseOrder())
    repeat(readln().toInt()) {
        val t = readln()
        if (t == "0") {
            if (pq.size == 0) println(0)
            else println(pq.poll())
        } else {
            pq.add(t.toInt())
        }
    }
}
