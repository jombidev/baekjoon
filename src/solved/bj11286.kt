fun main() {
    val pq = java.util.PriorityQueue(compareBy<Int> { Math.abs(it) }.thenComparingInt { it })
    repeat(readln().toInt()) {
        val t = readln()
        if (t == "0") {
            if (pq.isEmpty()) println(0)
            else println(pq.poll())
        } else {
            pq.add(t.toInt())
        }
    }
}

