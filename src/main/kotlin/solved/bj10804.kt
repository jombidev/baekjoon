package solved

fun main() {
    val to = Array(20) { it + 1 }

    List(10) { readln().split(' ').map { it.toInt() }.let { it[0]-1..<it[1] } }.forEach {
        flip(to, it)
    }
    println(to.joinToString(" "))
}

fun flip(src: Array<Int>, range: IntRange) {
    val size = range.last + 1 - range.first
    for (i in 0..size / 2 + 1) {
        val l = range.first + i
        val r = range.first + size - i - 1
        if (l >= r) break

        src[l] = src[r].also { src[r] = src[l] } // swap
    }
}
