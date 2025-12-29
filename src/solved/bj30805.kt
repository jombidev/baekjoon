import java.util.LinkedList

fun main() {
    readln()
    val n = readln().split(' ').map { it.toInt() }.toMutableList()
    readln()
    val m = readln().split(' ').map { it.toInt() }.toMutableList()

    val ll = LinkedList<Int>()

    fun findMax() {
        if (n.isEmpty())
            return
        val bs = m.sorted()

        var maxI = 0
        for (i in n) {
            val mi = bs.binarySearch(i)
            if (mi < 0) continue
            maxI = maxOf(bs[mi], maxI)
        }

        val ni = n.indexOf(maxI)
        if (ni == -1) return
        ll.add(n[ni])
        for (i in 0..ni)
            n.removeFirst()
        for (i in 0..m.indexOf(maxI))
            m.removeFirst()
        findMax()
    }

    findMax()
    println(ll.size)
    if (ll.isNotEmpty())
        print(ll.joinToString(" "))
}
