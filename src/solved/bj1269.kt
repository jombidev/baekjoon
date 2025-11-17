fun t() = readln().split(' ').toSet()
fun main() {
    readln()
    val a = t()
    val b = t()
    print((a - b).size + (b - a).size)
}
