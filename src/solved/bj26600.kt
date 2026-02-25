import java.util.StringTokenizer

fun main() = System.`in`.bufferedReader().use {
    fun readln() = it.readLine()
    val n = readln().toInt()
    val st = StringTokenizer(readln(), " ")
    val a = LongArray(n) { st.nextToken().toLong() }
    val rdx = LongArray(n)
    val pc = LongArray(101)
    val bc = LongArray(101)
    a.radix(rdx)

    val sb = StringBuilder()

    val q = readln().toInt()
    var ao = 0uL
    var mo = 1uL

    var performMod = false

    repeat(q) {
        val (cmd, op, num) = readln().split(' ')

        if (cmd == "map") {
            if (op == "%") {
                val n = num.toUInt()
                if (!performMod) {
                    for (i in a.indices) {
                        pc[((ao + mo * a[i].toULong() % n) % n).toInt()]++
                    }
                    performMod = true
                } else {
                    for (i in pc.indices) {
                        bc[i] = pc[i]
                        pc[i] = 0
                    }
                    for (i in pc.indices)
                        pc[((ao + mo * i.toUInt() % n) % n).toInt()] += bc[i]
                }
                ao = 0uL
                mo = 1uL
            } else {
                when (op) {
                    "+" -> ao += num.toUInt()
                    "*" -> {
                        ao *= num.toUInt()
                        mo *= num.toUInt()
                    }
                }
            }
        } else if (cmd == "filter") {
            val targ = num.toLong()

            if (!performMod) {
                val mt = targ.toULong() - ao
                sb.append(
                    when (op) {
                        ">=" -> {
                            a.size - a.lowerBound(((mt - 1u) / mo + 1u).toLong())
                        }
                        "<=" -> if ((mt / mo).toLong() == Long.MAX_VALUE) a.size else a.lowerBound((mt / mo + 1u).toLong())
                        else/*"=="*/ -> {
                            val rt = (mt / mo).toLong()
                            val li = a.lowerBound(rt)
                            if (li in a.indices && (a[li].toULong() * mo + ao).toLong() != targ) 0
                            else if (rt == Long.MAX_VALUE) a.size - li
                            else a.lowerBound(rt + 1) - li
                        }
                    }
                ).append('\n')
            } else {
                var count = 0L

                for (i in pc.indices) {
                    val oc = (mo * i.toULong() + ao).toLong()

                    count += if (targ > oc) {
                        if (op == "<=") pc[i] else 0L
                    } else if (targ < oc) {
                        if (op == ">=") pc[i] else 0L
                    } else {
                        pc[i]
                    }
                }

                sb.append(count).append('\n')
            }
        }
    }

    print(sb)
}

fun LongArray.lowerBound(key: Long): Int {
    var low = 0
    var high = lastIndex

    while (low <= high) {
        val mid = (low + high) ushr 1
        val midVal = this[mid]

        if (midVal < key) low = mid + 1
        else high = mid - 1
    }

    return low
}

fun LongArray.radix(buf: LongArray) {
    var asc = true
    var desc = true

    for (i in 0..<lastIndex) {
        if (this[i] > this[i + 1]) asc = false
        if (this[i] < this[i + 1]) desc = false
    }

    if (asc) return
    if (desc) {
        reverse()
        return
    }
    for (shift in 0..<64 step 8) {
        val count = IntArray(256)
        for (v in this) count[((v ushr shift) and 0xFF).toInt()]++
        if (count[0] == size) continue
        for (i in 1..255) count[i] += count[i - 1]
        for (i in lastIndex downTo 0) {
            val bucket = ((this[i] ushr shift) and 0xFF).toInt()
            buf[--count[bucket]] = this[i]
        }
        System.arraycopy(buf, 0, this, 0, size)
    }
}
