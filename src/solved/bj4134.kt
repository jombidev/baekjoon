fun main() {
    repeat(readln().toInt()) {
        var prime = readln().toLong()
        if (prime < 2) println(2)
        else {
            while (!isPrime(prime))
                prime += 1
            println(prime)
        }
    }
}

fun isPrime(i: Long): Boolean {
    if (i <= 1)
        return false
    if (i <= 3)
        return true
    for (n in 2..Math.sqrt(i + .0).toInt() + 1) {
        if (i % n == 0L)
            return false
    }
    return true
}
