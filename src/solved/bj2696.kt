import java.util.*

fun main() = repeat(readln().toInt()) {
    val n = readln().toInt()
    val min = PriorityQueue<Int>(n, reverseOrder())
    val max = PriorityQueue<Int>(n)

    val buf = LinkedList<Int>()

    println(n / 2 + 1)
    repeat(n) {
        if (buf.isEmpty())
            buf.addAll(readln().split(' ').map { it.toInt() })

        if (min.isEmpty() && max.isEmpty()) {
            min.add(buf.removeFirst())
        } else {
            val cen = min.peek()
            val targ = buf.removeFirst()

            if (targ > cen) max.add(targ)
            else min.add(targ)

            if (min.size - 1 > max.size) {
                max.add(min.remove())
            } else if (min.size - 1 < max.size) {
                min.add(max.remove())
            }
        }

        if (it % 2 == 0)
            println(min.peek())
    }
}
