import kotlin.math.*

fun main() {
    val n = readln().toLong()

    fun phi(i: Long): Long {
        var n = i
        var r = n

        for (i in 2..sqrt(n + .0).toInt()) {
            if (n % i == 0L) {
                while (n % i == 0L) n /= i
                r -= r / i
            }
        }

        if (n != 1L) r -= r / n
        return r
    }

    print(phi(n))
}
