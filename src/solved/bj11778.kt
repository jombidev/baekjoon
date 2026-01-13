fun main() {
    val mod = 1_000_000_007
    val (a, b) = readln().split(' ').map { it.toLong() }

    val m = HashMap<Long, Long>()
    fun fib(n: Long): Long {
        if (m[n] != null)
            return m[n]!!

        if (n == 1L || n == 0L)
            return n

        if (n % 2 == 0L) {
            val l = fib(n / 2) % mod
            val r = fib(n / 2 - 1) % mod
            m[n] = l * (l + 2 * r) % mod
        } else {
            val l = fib((n + 1) / 2) % mod
            val r = fib((n - 1) / 2) % mod
            m[n] = (l * l + r * r) % mod
        }

        return m[n]!! % mod
    }
    fun gcd(a: Long, b: Long): Long {
        val r = a % b
        if (r == 0L) return b
        return gcd(b, r)
    }

    print(fib(gcd(a, b)))
}
