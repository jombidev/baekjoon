import java.math.BigInteger
import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()

    val m = Array(n) { readln() }
    val ch = BooleanArray(36)
    ch[35] = true // Z
    val pq = PriorityQueue<Pair<BigInteger, Char>>(compareBy { -it.first })

    var c = readln().toInt()

    while (c-- > 0) {
        pq.clear()
        for (i in 0..<36) {
            if (ch[i]) continue
            val c = i.toString(36)[0].uppercaseChar()

            pq.add(m.sumOf { it.replace(c, 'Z').toBigInteger(36) } to c)
        }

        if (pq.isEmpty()) break

        val (_, mch) = pq.remove()
        ch[mch.digitToInt(36)] = true

        for (i in m.indices) {
            m[i] = m[i].replace(mch, 'Z')
        }
    }

    print(m.sumOf { it.toBigInteger(36) }.toString(36).uppercase())
}
