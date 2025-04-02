fun main() {
    val n = readln().toInt()
    if (n == 1) return
    var final = n
    while (final > 1) {
        for (i in 2..n) {
            if (final % i == 0) {
                final /= i
                println(i)
                break
            }
        }
    }
}
