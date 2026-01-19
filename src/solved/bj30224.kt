fun main() {
    val n = readln()

    val c = '7' in n
    val d = n.toInt() % 7 == 0

    print(if (!c && !d) 0 else if (!c) 1 else if (!d) 2 else 3)
}
