fun main() {
    val sz = readln().toInt()
    val m = List(sz) { readln().split(' ').map { it.toInt() }.let { Coord(it[0], it[1]) } }
    m.sortedWith(
        Comparator
            .comparing(Coord::x)
            .thenComparing(Coord::y)
    ).forEach(::println)
}

data class Coord(val x: Int, val y: Int) {
    override fun toString(): String = "$x $y"
}
