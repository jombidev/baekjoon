fun main() = print(f(readln().toLong()))
fun f(i: Long): Long = if (i < 2) 1 else i * f(i - 1)
