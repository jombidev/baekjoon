package solved

fun main() {
    for (i in 0 until readln().toInt()) {
        val l = ArrayDeque(readln().map { C(it, it == '(') })
        val lastElem = l.removeFirstOrNull()
        if (lastElem?.d != true) {
            println("NO")
            continue
        }
        val q = ArrayDeque<C>()
        q.add(lastElem)
        while (l.isNotEmpty()) {
            val c = l.removeFirst()
            if (c.d) {
                q.add(c)
                continue
            }
            if (q.removeLastOrNull() == null) {
                q.add(C(')', false))
                break
            }
        }
        println(if (q.isEmpty()) "YES" else "NO")
    }
}

data class C(val c: Char, val d: Boolean)