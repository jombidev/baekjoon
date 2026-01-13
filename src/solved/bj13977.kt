const val MOD = 1_000_000_007L
infix fun Long.t(n: Long) = times(n) % MOD

fun main() {
    fun exp(n: Long, k: Long): Long {
        if (k == 0L) return 1L
        val he = exp(n, k.ushr(1))
        return if (k and 1L == 1L) he t he t n else he t he
    }

    fun modp(n: Long) = exp(n, MOD - 2)

    val f = LongArray(4_000_002)
    f[0] = 1
    f[1] = 1

    for (i in 2..4_000_000)
        f[i] = f[i - 1] t i.toLong()

    val m = readln().toInt()

    repeat(m) {
        val (n, k) = readln().split(' ').map { it.toInt() }
        println(f[n] t modp(f[k]) t modp(f[n - k]))
    }
}
