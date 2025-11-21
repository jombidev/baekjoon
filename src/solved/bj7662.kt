import java.util.Comparator
import java.util.PriorityQueue

fun main() {
    repeat(readln().toInt()) {
        val minq = H()
        val maxq = H(reverseOrder())
        repeat(readln().toInt()) {
            val (o, n) = readln().split(' ')
            if (o == "I") {
                n.toInt().let {
                    minq.add(it)
                    maxq.add(it)
                }
            } else if (minq.isNotEmpty()) {
                val r = if (n[0] == '-') minq.peek() else maxq.peek()
                minq.remove(r)
                maxq.remove(r)
            }
        }

        println(if (minq.isEmpty()) "EMPTY" else "${maxq.peek()} ${minq.peek()}")
    }
}
class H(c: Comparator<Int>? = null) {
    val delq = PriorityQueue(c)
    val datq = PriorityQueue(c)

    fun add(i: Int) = datq.add(i)

    fun remove(i: Int) = delq.add(i)

    fun peek(): Int {
        adjust()
        return datq.peek()
    }

    private fun adjust() {
        while (delq.isNotEmpty() && delq.peek() == datq.peek()) {
            delq.remove()
            datq.remove()
        }
    }

    fun isEmpty(): Boolean {
        adjust()
        return datq.size == 0
    }

    fun isNotEmpty(): Boolean = !isEmpty()
}
