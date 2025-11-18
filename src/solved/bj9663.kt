import kotlin.math.abs

fun main() {
    val n = readln().toByte()
    val qns = Array(n + 1) { byteArrayOf(-1, -1) }
    val t = qns.bt(0, n, n)
    print(t)
}

fun Array<ByteArray>.placeable(x: Byte, y: Byte): Boolean {
    for (b in this) {
        if (b[0] < 0) continue
        if (b[0] == x || b[1] == y || abs(x - b[0]) == abs(y - b[1]))
            return false
    }

    return true
}

fun Array<ByteArray>.bt(x: Byte, r: Byte, n: Byte): Int {
    if (r < 1) return 1
    if (n == x) return 0

    var t = 0

    for (y in 0..<n) {
        val y = y.toByte()
        if (!placeable(x, y))
            continue

        this[r + 0][0] = x
        this[r + 0][1] = y
        t += bt((x + 1).toByte(), (r - 1).toByte(), n)
        this[r + 0][0] = -1
        this[r + 0][1] = -1
    }

    return t
}
