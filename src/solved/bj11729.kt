val moves = ArrayList<Pair<Int, Int>>()
fun main() {
    val n = readln().toInt()
    hanoi(n, 1, 3, 2)

    println(moves.size)
    print(moves.joinToString("\n") { "${it.first} ${it.second}" })
}

fun hanoi(i: Int, src: Int, dst: Int, tmp: Int) {
    if (i == 1) {
        moves.add(src to dst)
        return
    }

    hanoi(i - 1, src, tmp, dst)
    moves.add(src to dst)
    hanoi(i - 1, tmp, dst, src)
}
