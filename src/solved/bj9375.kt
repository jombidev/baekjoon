fun main() = repeat(readln().toInt()) {
    println(List(readln().toInt()) { readln().split(' ') }
        .groupBy { it[1] }
        .toList()
        .fold(1) { acc, p -> acc * (p.second.size + 1) } - 1
    )
}
