fun main() {
    val m = IntArray(4)
    repeat(readln().toInt()) {
        val (h, b) = readln().split(' ')

        if (h == "1")
            m[3]++
        else when (b) {
            in "12" -> m[0]++
            "3" -> m[1]++
            "4" -> m[2]++
        }
    }

    for (i in m) println(i)
}
