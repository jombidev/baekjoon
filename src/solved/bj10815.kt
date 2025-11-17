fun main() {
    readln()
    val s = readln().split(' ').toHashSet()
    readln()
    readln().split(' ').forEach { println(if (it in s)1 else 0) }
}
