import java.math.*

val TWO = BigDecimal.valueOf(2L)
val PI2 = BigDecimal("3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481").multiply(TWO)

val facto = ArrayList<BigDecimal>()
fun oddFactorial(n: Int): BigDecimal {
    while (facto.size < n) {
        val lfi = facto.lastIndex
        val f = lfi
        val off = BigDecimal.ONE.add(f.toBigDecimal()).multiply(TWO)
        facto.add(
            facto[lfi]
                .multiply(off)
                .multiply(off + BigDecimal.ONE)
        )
    }

    return facto[n - 1]
}

fun sin(x: BigDecimal): BigDecimal {
    var x = x

    val mc = MathContext(MathContext.DECIMAL128.getPrecision() + 6, RoundingMode.HALF_EVEN)

    if (x.abs() > PI2) x = x.remainder(PI2, mc)

    val error = BigDecimal.ONE.movePointLeft(MathContext.DECIMAL128.getPrecision() + 1)

    var sum = BigDecimal.ZERO
    val pow = x.multiply(x, MathContext.DECIMAL128)
    var powCache = x
    var i = 1
    var neg = false
    var s: BigDecimal
    do {
        val facto = oddFactorial(i)
        s = powCache.divide(facto, MathContext.DECIMAL128)
        if (neg)
            s = s.negate(MathContext.DECIMAL128)
        neg = !neg

        powCache = powCache.multiply(pow, MathContext.DECIMAL128)
        sum = sum.add(s, MathContext.DECIMAL128)
        i++
    } while (s.abs() > error)

    return sum.round(MathContext.DECIMAL128)
}

fun main() {
    facto.add(BigDecimal.ONE) // 1!

    val (a, b, c) = readln().split(' ').map { it.toBigDecimal() }
    val error = BigDecimal.ONE.movePointLeft(20)

    fun bsearch(l: BigDecimal, r: BigDecimal): BigDecimal {
        val m = l + (r - l).divide(TWO)

        val res = a * m + b * sin(m)

        return if ((c - res).abs() <= error) {
            m
        } else {
            when (res.compareTo(c)) {
                1 -> bsearch(l, m)
                -1 -> bsearch(m, r)
                else -> bsearch(l, r)
            }
        }
    }

    val res = bsearch(BigDecimal.ZERO, c.multiply(TWO))
    print(res.setScale(6, RoundingMode.HALF_EVEN))
}
