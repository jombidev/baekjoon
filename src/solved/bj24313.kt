fun main() {
    val (a1, a0) = readln().split(' ').map { it.toInt() }
    val c = readln().toLong()
    val n0 = readln().toLong()

    fun f(n: Long) = a1 * n + a0
    fun judge(n: Long) = f(n) <= c * n

    print(if (judge(n0) && a1 <= c) 1 else 0)
}
