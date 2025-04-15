fun main() {
    var min = 0
    val m = List(11) { readln().split(' ').map { it.toInt() } }
        .sortedWith(
            Comparator
                .comparing<List<Int>, Int> { it[0] }
                .thenComparingInt { -it[1] }
        )
        .sumOf { min += it[0];it[1] * 20 + min }
    println(m)
}
