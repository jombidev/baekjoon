fun main() {
    val (i, j) = readln().split(' ').map { it.toInt() }
    val s = List(i) { readln() }.toHashSet()
    println((1..j).sumOf { +if (readln() in s) 1 else 0 })
}
