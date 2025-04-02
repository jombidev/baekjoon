fun main() = String(System.`in`.readBytes()).split('\n').forEach {
    val (a, b, c) = it.split(' ').map { it.toDouble() }.sorted()
    if (a == .0) return
    println(if (a * a + b * b == c * c) "right" else "wrong")
}
