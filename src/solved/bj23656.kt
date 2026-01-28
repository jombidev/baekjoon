fun flush() = System.out.flush()
fun main() {
    var step = 0
    var min = 1L
    var max = 1_000_000_000L

    while (++step <= 100) {
        val n = readln().toLong()

        if (step < 30) {
            val mid = min + (max - min).ushr(1)
            if (mid >= n && n + 1 <= max || mid < n && n - 1 < min) {
                min = maxOf(min, n + 1)
                println(">")
            } else {
                max = minOf(max, n - 1)
                println("<")
            }
        } else {
            println(if (max < n) "<" else if (min > n) ">" else "=")
            if (n in min..max) break
        }
        flush()
    }
}
