val isPrime = MutableList(101) { true }
val primes = LinkedHashSet<Int>()

fun main() {
    isPrime[0] = false
    isPrime[1] = false

    repeat(readln().toInt()) {
        val n = readln().toInt()
        sieve(n)

        var pc = 0
        for (i in primes) {
            if (i > n / 2)
                break
            if (isPrime[n - i])
                pc++
        }
        println(pc)
    }
}

fun sieve(i: Int) {
    while (isPrime.size <= i)
        isPrime.add(true)

    for (r in 2..i) {
        if (isPrime[r]) {
            primes.add(r)
            for (s in r..i step r)
                isPrime[s] = false
            isPrime[r] = true
        }
    }
}
