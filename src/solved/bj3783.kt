import java.math.*

val TWO = BigDecimal.valueOf(2)
val THREE = BigDecimal.valueOf(3)
val PREC150 = MathContext(101, RoundingMode.FLOOR)
val precision = BigDecimal.ONE.movePointLeft(PREC150.precision + 1)

fun main() {
    repeat(readln().toInt()) {
        val x = readln().toBigDecimal()
        var prev: BigDecimal
        var n = x.divide(TWO)
        do {
            prev = n
            val np = n.multiply(n, PREC150)
            n = x.divide(np, PREC150).add(TWO.multiply(n)).divide(THREE, PREC150)
        } while ((prev - n).abs() >= precision)
        println(n.setScale(10, RoundingMode.FLOOR))
    }
}
