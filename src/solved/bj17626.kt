fun main() {
    val target = readln().toInt()
    var min = 4
    for (i in 1..223) {
        val ii = i * i
        if (target == ii) return print(1)
        for (j in 1..223) {
            val jj = ii + j * j
            if (target == jj) min = minOf(min, 2)
            if (min > 3)
                for (k in 1..223) {
                    val kk = jj + k * k
                    if (target == kk) min = minOf(min, 3)
                }
        }
    }
    print(min)
}
