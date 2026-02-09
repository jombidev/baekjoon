fun main() {
    val n = readln().toInt()
    val a = readln().split(' ').map { it.toInt() }.sorted()

    val x = readln().toInt()

    var l = 0
    var r = n - 1
    var c = 0

    while (r > 0) {
        val sum = a[l] + a[r]
        if (l >= r) {
            r--
            l = 0
            continue
        }
        if (sum < x) {
            l++
        } else if (sum > x) {
            r--
            l = 0
        } else {
            l++
            c++
        }
    }

    print(c)
}
