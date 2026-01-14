import java.math.*

fun main() {
    val (a, b) = readln().split(' ')

    fun exp(n: BigDecimal, k: Int): BigDecimal {
        if (k == 0) return BigDecimal.ONE
        val he = exp(n, k.ushr(1))
        return if (k and 1 == 1) he * he * n else he * he
    }

    print(exp(a.toBigDecimal(), b.toInt()).toPlainString())
}
