fun main() {
    val m = readln().map { it - '0' }

    var sb = false
    var b = false
    var t = 0
    for (i in 0..<m.size - 1) {
        if (m[i] != -6) {
            t += (if (b) 3 else 1) * m[i]
        } else {
            sb = b
        }
        b = !b
    }
    val thingy = t + m.last()
    for (i in 0..9) {
        if ((thingy + i * if (sb) 3 else 1) % 10 == 0)
            return print(i)
    }
    print(thingy)
}
