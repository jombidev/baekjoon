fun main() {
    val (l, s) = readln().split(' ').map { it.toInt() }
    val noListen = List(l) { readln() }.toSet()
    val noSee = List(s) { readln() }.toSet()

    val whoAreYou = (noListen intersect noSee)
    println(whoAreYou.size)
    whoAreYou.sorted().forEach(::println)
}
