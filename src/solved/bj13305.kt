fun main() {
    val n = readln().toInt()
    val o = readln().split(' ').map { it.toInt() }
    val ps = LongArray(n)
    for (i in 1..<n) ps[i] = ps[i - 1] + o[i - 1]

    val p = readln().split(' ').map { it.toInt() }.dropLast(1)

    var lastPrice = p[0]
    var lastIndex = 0

    var totalPrice = 0L

    for ((i, price) in p.withIndex()) {
        if (i == 0) continue
        if (price > lastPrice) continue

        totalPrice += (ps[i] - ps[lastIndex]) * lastPrice
        lastIndex = i
        lastPrice = price
    }

    totalPrice += (ps.last() - ps[lastIndex]) * lastPrice

    print(totalPrice)
}
