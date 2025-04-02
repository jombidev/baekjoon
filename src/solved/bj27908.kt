import java.util.LinkedList

fun main() {
    val (d, s) = readln().split(' ').map { it.toInt() }
    val sb = StringBuilder("+---------------------+\n")
    val lst = LinkedList(List(s-1) { "..." } + List(d) { format(it + 1) })
    var cnt = 0
    while (lst.isNotEmpty()) {
        val i = lst.removeFirst()
        if (cnt == 0) sb.append('|')
        sb.append(i)
        cnt++
        if (cnt >= 7) {
            sb.append("|\n")
            cnt = 0
        }
    }
    if (cnt != 0) {
        for (i in cnt until 7) sb.append("...")
        sb.append("|\n")
    }
    sb.append("+---------------------+")
    print("$sb")
}
fun format(i: Int): String {
    val e = "%03d".format(i).replace('0', '.')
    return if (e.last() == '.') (e.take(2) + '0') else e
}
