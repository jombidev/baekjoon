fun main() {
    val target = readln().toInt()

    val isPrime = BooleanArray(4000044) { true }
    val primes = ArrayList<Int>()
    isPrime[0] = false
    isPrime[1] = false

    for (r in 2..4000043) {
        if (isPrime[r]) {
            primes.add(r)
            for (s in r.toLong() * r..4000043 step r.toLong())
                isPrime[s.toInt()] = false
        }
    }

    val ps = LongArray(primes.size + 1)
    for (i in primes.indices) ps[i + 1] = ps[i] + primes[i]

    var l = 0
    var r = 0
    var tc = 0

    while (r < primes.size) {
        val n = ps[r] - ps[l]

        if (n == target.toLong()) {
            tc++
            l++
        } else if (n < target && r < primes.size) {
            r++
        } else {
            l++
        }
    }
    print(tc)
}
