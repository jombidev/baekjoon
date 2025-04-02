fun main() {
    val (a, b, c) = List(3) { readln().toInt() }
    println(a + b - c)
    println("$a$b".toInt() - c)
}
