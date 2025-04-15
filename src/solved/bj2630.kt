fun main() {
    val sz = readln().toInt()
    val m = List(sz) { readln().split(' ').map { it[0] } }
    val v = Array(sz) { Array(sz) { false } }
    val wb = Array(2) { 0 }

    var l = sz
    while (l > 0) {
        for (offY in 0..<sz / l) {
            for (offX in 0..<sz / l) {
                wb@ for (k in "01") {
                    for (i in 0..<l) {
                        for (j in 0..<l) {
                            if (v[offY * l + i][offX * l + j]) break@wb
                            if (m[offY * l + i][offX * l + j] != k)
                                continue@wb
                        }
                    }
                    for (i in 0..<l) {
                        for (j in 0..<l) {
                            v[offY * l + i][offX * l + j] = true
                        }
                    }
                    wb[k-'0']++
                }
            }
        }
        l /= 2
    }
    println(wb.joinToString("\n"))
}
