fun main() {
    var n = 1000 - readln().toInt()
    val a = listOf(500, 100, 50, 10, 5, 1)
    var c = 0
    for (i in a.indices) {
        c += n / a[i]
        n %= a[i]
    }
    print(c)
}
