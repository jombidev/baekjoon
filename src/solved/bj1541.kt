fun main() {
    val t = readln()
    println(
        t.split('-').map {
            it.split('+').sumOf { it.toInt() }
        }.reduce(Int::minus)
    )
}
