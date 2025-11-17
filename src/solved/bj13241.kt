fun main()=print(readln().split(' ').map { it.toLong() }.let { (a, b) -> a * b / gcd(a, b) })

fun gcd(a: Long, b: Long): Long {
    val r = a % b
    if (r == 0L) return b
    return gcd(b, r)
}
