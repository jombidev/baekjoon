fun main() = System.`in`.bufferedReader().use {
    fun r() = it.readLine()
    val (n, q) = r().split(' ').map { it.toInt() }
    val a = r().split(' ').map { it.toInt() }.toMutableList()
    val ogl = a.groupingBy { it }.eachCount()

    val cseg = IntArray(400000)
    val sseg = LongArray(400000)

    fun mkseg(l: Int = 1, r: Int = 100000, N: Int = 1): Int {
        if (l == r) {
            ogl[l]?.let {
                cseg[N] = it
                sseg[N] = l.toLong() * it
            }
            return N
        }

        val m = l + (r - l).shr(1)

        val lSeg = mkseg(l, m, N * 2)
        val rSeg = mkseg(m + 1, r, N * 2 + 1)

        cseg[N] = cseg[lSeg] + cseg[rSeg]
        sseg[N] = sseg[lSeg] + sseg[rSeg]
        return N
    }

    fun addseg(mi: Int, l: Int = 1, r: Int = 100000, N: Int = 1) {
        if (mi !in l..r) return
        cseg[N]++
        sseg[N] = sseg[N] + mi

        if (l != r) {
            val m = l + (r - l).shr(1)
            addseg(mi, l, m, N * 2)
            addseg(mi, m + 1, r, N * 2 + 1)
        }
    }

    fun subseg(mi: Int, l: Int = 1, r: Int = 100000, N: Int = 1) {
        if (mi !in l..r) return
        cseg[N]--
        sseg[N] = sseg[N] - mi

        if (l != r) {
            val m = l + (r - l).shr(1)
            subseg(mi, l, m, N * 2)
            subseg(mi, m + 1, r, N * 2 + 1)
        }
    }

    mkseg()

    val sb = StringBuilder()
    repeat(q) {
        val cmd = r().split(' ').map { it.toInt() }
        when (cmd[0]) {
            1 -> {
                val (_, j, v) = cmd

                val prev = a[j - 1]
                a[j - 1] = v
                subseg(prev)
                addseg(v)
            }

            2 -> {
                var t = cmd[1].toLong()
                var tc = 0

                fun findseg(l: Int = 1, r: Int = 100000, N: Int = 1) {
                    if (l == r) {
                        val can = minOf(cseg[N], (t / l).toInt())
                        tc += can
                        t -= can * l
                        return
                    }

                    val m = l + (r - l).ushr(1)

                    if (sseg[N * 2] <= t) {
                        t -= sseg[N * 2]
                        tc += cseg[N * 2]
                        findseg(m + 1, r, N * 2 + 1)
                    } else {
                        findseg(l, m, N * 2)
                    }
                }

                findseg()
                sb.append(tc).append(' ')
            }

            3 -> {
                val v = cmd[1]
                a.add(v)
                addseg(v)
            }
        }
    }

    print(sb)
}
