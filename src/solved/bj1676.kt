fun main() {
    var m = 1.toBigInteger()
    for (l in (2L..readln().toLong())) {
        m = m.multiply(l.toBigInteger())
    }
    println(m.toString().let { it.length - it.lastIndexOfAny("123456789".toCharArray()) } - 1)
}
