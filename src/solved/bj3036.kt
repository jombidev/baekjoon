fun main() {
    readln()
    val lst = readln().split(' ').map { it.toInt() }.toCollection(ArrayDeque())
    val ref = lst.removeFirst()
    while (lst.isNotEmpty()) {
        val target = lst.removeFirst()
        val lcm = euclidean(ref, target)
        println("${ref / lcm}/${target / lcm}")
    }
}

private fun euclidean(i: Int, j: Int): Int {
    var a = i
    var b = j
    var tmp: Int
    while (b != 0) {
        tmp = a
        a = b.also { b = tmp % b }
    }
    return a
}
