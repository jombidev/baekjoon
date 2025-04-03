fun main() {
    val (min, max) = readln().split(' ').map { it.toInt() }
    print(sieve(min, max).joinToString("\n"))
}

fun sieve(min: Int, i: Int): List<Int> {
    val isPrime = Array(i + 1) { true }
    val primes = ArrayList<Int>()
    isPrime[0] = false
    isPrime[1] = false

    for (r in 2..i) {
        if (isPrime[r]) {
            if (min <= r)
                primes.add(r)
            for (s in r..i step r)
                isPrime[s] = false
        }
    }
    return primes
}
