fun main() {
    val isPrime = Array(320001) { true }
    val primes = ArrayList<Int>(27450)
    val superPrimes = ArrayList<Int>()

    isPrime[0] = false
    isPrime[1] = false

    for (r in 2..320000) {
        if (isPrime[r]) {
            primes.add(r)
            for (s in r.toLong() * r..320000L step r.toLong()) {
                if (s > 320000L) break
                isPrime[s.toInt()] = false
            }
        }
    }

    for (i in primes) {
        if (i > 27449) break
        superPrimes.add(primes[i - 1])
    }

    repeat(readln().toInt()) {
        println(superPrimes[readln().toInt() - 1])
    }
}
