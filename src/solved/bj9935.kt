import java.util.LinkedList

fun main() {
    val t = readln()
    val b = readln()

    val s = LinkedList<Char>()
    val d = LinkedList<Char>()

    for (ch in t) {
        s.add(ch)

        if (s.size >= b.length) {
            for (i in b.indices) {
                val rem = s.removeLast()
                d.addLast(rem)
                if (b[b.lastIndex - i] != rem) {
                    while (d.isNotEmpty())
                        s.addLast(d.removeLast())
                    break
                }
            }

            if (d.isNotEmpty())
                d.clear()
        }
    }

    println(if (s.isEmpty()) "FRULA" else s.joinToString(""))
}
