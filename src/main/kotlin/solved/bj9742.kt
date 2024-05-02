package solved

fun main() = System.`in`.bufferedReader().forEachLine {
    count = 0
    for (i in 0..<10) {
        ar[i] = ' '
        v[i] = false
    }
    val (str, time) = it.split(' ')
    if (time.toInt() - 1 >= (2..str.length).reduce(Int::times)) return@forEachLine println("$it = No permutation")

    val m = getNextSy(str, 0, time.toInt())
    println("$it = ${m!!.trim()}")
}

private val ar = Array(10) { ' ' }
private val v = Array(10) { false }
private var count = 0

fun getNextSy(str: String, pos: Int, index: Int): String? {
    if (pos == str.length && ++count == index) return ar.joinToString("")
    for (i in str.indices) {
        if (!v[i]) {
            v[i] = true
            ar[pos] = str[i]
            val m = getNextSy(str, pos + 1, index)
            if (m != null) return m
            v[i] = false
        }
    }
    return null
}