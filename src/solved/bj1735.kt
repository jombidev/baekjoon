fun r() = readln().split(' ').map { it.toInt() }
fun main() {
    val (at, ab) = r()
    val (bt, bb) = r()
    val st = at * bb + bt * ab
    val sb = ab * bb
    val gcd = gcd(st, sb)

    print("${st / gcd} ${sb / gcd}")
}

fun gcd(a: Int, b: Int): Int {
    val r = a % b
    if (r == 0) return b
    return gcd(b, r)
}
