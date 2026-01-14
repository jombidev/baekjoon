const val mod = 1_000_000_007L
fun main() {
    val (n, a) = readln().split(' ').map { it.toLong() }

    fun exp(n: Long, k: Long): Long {
        if (k == 0L) return 1L
        val he = exp(n, k shr 1) % mod
        val m = he * he % mod
        return if (k and 1L == 1L) m * n % mod else m
    }

    print(((exp(n, a) * (n - 1) % mod) - ((n - 2) * exp(n - 1, a) % mod) + mod) % mod * n % mod)
}
