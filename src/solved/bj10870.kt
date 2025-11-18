fun main() = print(f(readln().toInt()))
fun f(i: Int): Int = if (i < 2) i else f(i - 1) + f(i - 2)
