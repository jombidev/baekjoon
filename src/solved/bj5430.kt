fun main() {
    repeat(readln().toInt()) {
        val act = readln()
        readln()
        val q = java.util.LinkedList(readln().let { it.substring(1, it.lastIndex) }.split(',').filter { it.isNotEmpty() }.map { it.toInt() })
        var p = false
        for (ch in act) {
            if (ch == 'R')
                p = !p
            else if (ch == 'D') {
                if (q.isEmpty())
                    return@repeat println("error")

                (if (p) q::removeLast else q::removeFirst)()
            }
        }
        println("[${(if (p) q.reversed() else q).joinToString(",")}]")
    }
}
