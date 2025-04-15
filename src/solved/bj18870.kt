fun main() {
    readln()
    val arr = readln().split(' ').map { it.toInt() }
    var i = 0
    val sorted = arr.toSortedSet().associateWith { i++ }

    print(arr.map { sorted[it] }.joinToString(" "))
}
