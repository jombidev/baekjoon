fun main() = repeat(readln().toInt()) {
    val m = readln().split(' ')
    var s = m[0].toDouble()

    for (a in m) {
        when (a) {
            "@" -> s *= 3
            "%" -> s += 5
            "#" -> s -= 7
        }
    }

    println("%.2f".format(s))
}
