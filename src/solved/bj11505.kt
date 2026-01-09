import kotlin.math.ceil
import kotlin.math.log2


fun main() = System.`in`.bufferedReader().use {
    val MOD = 1_000_000_007L

    fun r() = it.readLine()
    val (n, m, k) = r().split(' ').map { it.toInt() }
    val nums = LongArray(n) { r().toLong() % MOD }

    val height = ceil(log2(n + .0)).toInt()
    val segLen = 1 shl (height + 1)

    val seg = LongArray(segLen)

    fun mkseg(l: Int = 0, r: Int = n - 1, N: Int = 1): Long {
        if (l == r) {
            seg[N] = nums[l]
            return seg[N]
        }

        val m = l + (r - l).shr(1)

        seg[N] = mkseg(l, m, N * 2) * mkseg(m + 1, r, N * 2 + 1) % MOD
        return seg[N]
    }

    mkseg(0, n - 1, 1)

    fun modseg(mi: Int, d: Long, l: Int = 0, r: Int = n - 1, N: Int = 1): Long {
        if (mi !in l..r) return seg[N]

        if (l == r) {
            seg[N] = d
            return seg[N]
        }

        val m = l + (r - l).shr(1)
        seg[N] = modseg(mi, d, l, m, N * 2) * modseg(mi, d, m + 1, r, N * 2 + 1) % MOD
        return seg[N]
    }

    fun sumseg(s: Int, e: Int, l: Int = 0, r: Int = n - 1, N: Int = 1): Long {
        if (s > r || e < l) return 1
        if (s <= l && r <= e) return seg[N]

        val m = l + (r - l).shr(1)
        return sumseg(s, e, l, m, N * 2) * sumseg(s, e, m + 1, r, N * 2 + 1) % MOD
    }

    repeat(m + k) {
        val (a, b, c) = r().split(' ').map { it.toLong() }

        if (a == 1L) {
            modseg(b.toInt() - 1, c)
        } else {
            println(sumseg(b.toInt() - 1, c.toInt() - 1))
        }
    }
}
