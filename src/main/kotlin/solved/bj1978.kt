package solved

fun main() {
    readln()
    val m = readln().split(' ').map { it.toInt() }
    val primes = arrayListOf(2)
    val ax = m.max()
    var calc = 3
    var cnt = 0
    m@ while (primes.last() <= ax) {
        for (n in primes) {
            if (calc % n == 0) {
                calc += 2
                continue@m
            }
        }
        if (calc in m) ++cnt
        primes.add(calc)
        calc += 2
    }
    if (2 in m) ++cnt
    print(cnt)
}