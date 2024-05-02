package solved

fun main() {
    for (i in 0..<readln().toInt()) {
        validate(readln())
    }
}

fun validate(str: String) {
    val h = HashMap<Char, Int>()
    var nextSame: Char? = null
    for (c in str) {
        if (nextSame == null) h[c] = ((h[c] ?: 0) + 1) % 3
        if (nextSame != null) {
            if (c != nextSame) return println("FAKE")
            nextSame = null
        }else if (h[c]!! == 0) nextSame = c
    }
    println(if (nextSame != null) "FAKE" else "OK")
}