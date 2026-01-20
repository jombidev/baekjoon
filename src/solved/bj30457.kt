import java.util.LinkedList

fun main() {
    readln()
    val map = readln().split(' ').map { it.toInt() }.sorted()
    val ll = LinkedList<Int>()
    val rl = LinkedList<Int>()
    val set = HashSet<Int>()

    for (i in map) {
        if (set.add(i))
            ll.add(i)
        else
            rl.add(i)
    }

    ll.addAll(rl.distinct().sortedDescending())

    println(ll.size)
}
