fun main() {
    val n = readln().toInt()
    println((1L..<n - 1L).sumOf { it * (it + 1) / 2 })
    println(3)
}
