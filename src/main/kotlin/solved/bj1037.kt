package solved

fun main() {
    readln()
    print(readln().split(' ').map { it.toInt() }.sorted().let { it[0] * it.last() })
}