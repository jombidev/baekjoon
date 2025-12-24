fun main() {
    val n = readln().toInt()
    val mod = 1_000_000_007L

    fun exp(n: Long, k: Long): Long {
        if (k == 0L) return 1L
        val he = exp(n, k shr 1) % mod
        val m = he * he % mod
        return if (k and 1L == 1L) m * n % mod else m
    }

    print(
        (1..n).sumOf {
            val (n, s) = readln().split(' ').map { it.toLong() }
            s * exp(n, mod - 2L) % mod
        } % mod
    )
}
