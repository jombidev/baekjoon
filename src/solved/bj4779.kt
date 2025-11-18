import kotlin.math.pow

fun main() = System.`in`.reader().readLines().forEach {
    val n = it.toInt()
    if (n == 0) return@forEach println('-')
    val s = Array(3.0.pow(n).toInt()) { '-' }

    cantor(s)
    println(s.joinToString(""))
}

fun cantor(s: Array<Char>, l: Int = 0, r: Int = s.lastIndex) {
    val len = (r - l + 1) / 3
    if (len <= 0)
        return
    cantor(s, l, l + len - 1)
    for (i in l + len ..r - len)
        s[i] = ' '
    cantor(s, r - len + 1, r)
}
