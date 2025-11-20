import kotlin.math.pow

fun main() {
    val (n, r, c) = readln().split(' ').map { it.toInt() }

    print(dnc(n, r, c))
}

val base = arrayOf(arrayOf(0, 1), arrayOf(2, 3))

fun dnc(n: Int, r: Int, c: Int): Int {
    if (n == 1) {
        return base[r][c]
    }

    val wh = 2.0.pow(n).toInt() / 2
    var spliter = 0
    if (c >= wh)
        spliter++
    if (r >= wh)
        spliter += 2

    val offset = wh * wh * spliter

    return offset + dnc(n - 1, r % wh, c % wh)
}
