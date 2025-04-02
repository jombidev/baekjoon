fun main() {
    val (n, d) = readln().split(" ").map { it.toInt() }
    val solves = List(n) { readln().toInt() }
    val perPrice = d / solves.sum()
    solves.map { perPrice * it }.forEach(::println)
}
