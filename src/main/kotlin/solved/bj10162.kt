package solved

fun main() {
    var q = readln().toInt()
    if (q % 10 != 0) return print(-1)
    val a = listOf(300, 60, 10)
    val c = Array(3) { 0 }
    for (i in 0..<3) {
        val m = q / a[i]
        c[i] = m
        q %= a[i]
    }
    print(c.joinToString(" "))
}