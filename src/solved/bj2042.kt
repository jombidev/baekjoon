import kotlin.math.ceil
import kotlin.math.log2

fun main() = System.`in`.bufferedReader().use {
    fun r() = it.readLine()
    val (n, m, k) = r().split(' ').map { it.toInt() }
    val nums = LongArray(n) { r().toLong() }

    val height = ceil(log2(n + .0)).toInt()
    val segLen = 1 shl (height + 1)

    val seg = LongArray(segLen)

    fun mkseg(l: Int = 0, r: Int = n - 1, N: Int = 1): Long {
        if (l == r) {
            seg[N] = nums[l]
            return seg[N]
        }

        val m = l + (r - l).shr(1)

        seg[N] = mkseg(l, m, N * 2) + mkseg(m + 1, r, N * 2 + 1)
        return seg[N]
    }

    mkseg(0, n - 1, 1)

    fun _modseg(mi: Int, d: Long, l: Int = 0, r: Int = n - 1, N: Int = 1) {
        if (mi !in l..r) return
        seg[N] += d

        if (l != r) {
            val m = l + (r - l).shr(1)
            _modseg(mi, d, l, m, N * 2)
            _modseg(mi, d, m + 1, r, N * 2 + 1)
        }
    }

    fun modseg(mi: Int, v: Long) {
        val d = v - nums[mi]
        nums[mi] = v
        _modseg(mi, d)
    }

    fun sumseg(s: Int, e: Int, l: Int = 0, r: Int = n - 1, N: Int = 1): Long {
        if (s > r || e < l) return 0
        if (s <= l && r <= e) return seg[N]

        val m = l + (r - l).shr(1)
        return sumseg(s, e, l, m, N * 2) + sumseg(s, e, m + 1, r, N * 2 + 1)
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
