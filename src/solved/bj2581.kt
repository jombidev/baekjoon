fun main() {
    val min = readln().toInt()
    val max = readln().toInt()
    val primes = arrayListOf(2)
    var calc = 3
    m@ while (primes.last() <= max) {
        for (n in primes) {
            if (calc % n == 0) {
                calc += 2
                continue@m
            }
        }
        primes.add(calc)
        calc += 2
    }
    val rn = min..max
    val n = primes.filter { it in rn }
    print(if (n.isEmpty()) "-1" else "${n.sum()} ${n.min()}")
}
