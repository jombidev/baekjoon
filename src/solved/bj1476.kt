fun main() {
    val (a, b, c) = readln().split(' ').map { it.toInt() - 1 }

    for (i in 0..<7980) {
        if (i % 15 == a && i % 28 == b && i % 19 == c)
            return print(i + 1)
    }
}
