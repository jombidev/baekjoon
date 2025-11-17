fun main() {
    val tk = readln().split(' ')[1].toInt()
    println(readln().split(' ').map{ it.toInt() }.sorted().takeLast(tk)[0])
}
