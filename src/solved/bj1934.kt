fun main() {
    repeat(readln().toInt()) {
        println(readln().split(' ').map { it.toInt() }.let { (a, b) -> a * b / gcd(a, b) })
    }
}

fun gcd(a: Int, b: Int): Int {
    for (i in minOf(a,b) downTo 1) {
        if (a % i == 0 && b % i == 0)
            return i
    }
    return 1
}
