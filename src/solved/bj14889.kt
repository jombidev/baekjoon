val tb = Array(2) { IntArray(0) }
val tbi = IntArray(2)
fun main() {
    val n = readln().toInt()
    val s = Array(n) { readln().split(' ').map { it.toInt() }.toIntArray() }
    val v = BooleanArray(n) { false }
    for (i in tb.indices)
        tb[i] = IntArray(n / 2)

    var minDiff = Int.MAX_VALUE
    s.bt(v) {
        minDiff = minOf(minDiff, it)
    }

    print(minDiff)
}

fun Array<IntArray>.bt(v: BooleanArray, p: Int = 0, callback: (Int) -> Unit) {
    val tn = size / 2
    if (v.count { it } == tn) {
        for (i in tbi.indices)
            tbi[i] = 0
        for ((i, b) in v.withIndex()) {
            val m = if (b) 1 else 0
            tb[m][tbi[m]++] = i
        }

        var lSum = 0
        var rSum = 0
        for (i in 0..<tn) {
            for (j in i..<tn) {
                lSum += this[tb[0][i]][tb[0][j]] + this[tb[0][j]][tb[0][i]]
                rSum += this[tb[1][i]][tb[1][j]] + this[tb[1][j]][tb[1][i]]
            }
        }

        callback(Math.abs(lSum - rSum))
        return
    }

    for (i in p + 1..size) {
        v[p] = true
        bt(v, i, callback)
        v[p] = false
    }
}
