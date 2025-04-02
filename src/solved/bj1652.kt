fun main() {
    val m = List(readln().toInt()) { readln() }

    print("${a(m, false)} ${a(m, true)}")
}
fun a(m: List<String>, gs: Boolean): Int {
    var a = 0
    for (i in m.indices) {
        var n = 0
        for (j in m.indices) {
            when (if (gs) m[j][i] else m[i][j]) {
                '.' -> n++
                'X' -> n = 0
            }
            if (n == 2) {
                a++
                continue
            }
        }
    }
    return a
}
