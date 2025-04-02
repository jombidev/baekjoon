fun main() {
    val (a, b) = readln().split(' ').map { it.toInt() }
    val lcm = euclidean(a, b)
    print("$lcm ${a * b / lcm}")
}

private fun euclidean(i: Int, j: Int): Int {
    var a = i
    var b = j
    var tmp: Int
    while (b != 0) {
        tmp = a
        a = b.also { b = tmp % b }
    }
    return a
}
