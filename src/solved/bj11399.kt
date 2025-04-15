fun main() {
    readln()
    val m = readln().split(' ').mapIndexed { i, it -> i to it.toInt() }.sortedBy { it.second }
    var z = 0
    m.fold(0) { t, it -> (t + it.second).also { z += it } }
    println(z)
}
