package solved

fun main() = with (StringBuilder()) {
    val (a, b) = readln().split(' ').map { it.toInt() }
    val q = ArrayDeque(setOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47))
    l@
    for (i in a until b) {
        for (j in q) if (i % j == 0) continue@l
        q.add(i)
        append("$i\n")
    }
    print("$this")
}