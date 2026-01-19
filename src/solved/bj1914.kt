import java.math.BigInteger

fun main() {
    fun exp(n: BigInteger, k: Int): BigInteger {
        if (k == 0) return BigInteger.ONE
        val he = exp(n, k.ushr(1))
        return if (k and 1 == 1) he * he * n else he * he
    }

    val n = readln().toInt()
    println(exp(2.toBigInteger(), n).subtract(BigInteger.ONE))
    if (n < 21) print(StringBuilder().apply { hanoi(n, 1, 3, 2) })
}

fun StringBuilder.hanoi(i: Int, src: Int, dst: Int, tmp: Int) {
    if (i == 1) {
        append(src).append(' ').append(dst).append('\n')
        return
    }

    hanoi(i - 1, src, tmp, dst)
    append(src).append(' ').append(dst).append('\n')
    hanoi(i - 1, tmp, dst, src)
}
