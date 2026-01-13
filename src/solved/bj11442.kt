fun main() {
    val mod = 1_000_000_007
    var n = readln().toLong()

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

    if (n % 2 == 0L)
        n -= 1

    print((fib(n + 1) - fib(2) + 1) % mod)
}
