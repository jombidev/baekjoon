fun main() {
    val a = readln().split(' ').map { it.toInt() }
    val b = readln().split(' ').map { it.toInt() }

    var w = 0
    for (i in a)
        w += b.count { it < i }

    val l = lcm(w, 36)

    print("${w / l}/${36 / l}")
}

fun lcm(i: Int, j: Int): Int {
    var a = i
    var b = j
    var tmp: Int
    while (b != 0) {
        tmp = a
        a = b.also { b = tmp % b }
    }
    return a
}
