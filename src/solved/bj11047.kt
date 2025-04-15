fun main() {
    var (c, total) = readln().split(' ').map { it.toInt() }
    val t = List(c) { readln().toInt() }.reversed()
    c = 0
    t.forEach {
        c += total / it
        total %= it
    }
    print(c)
}
