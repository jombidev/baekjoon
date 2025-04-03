fun main() {
    readln()
    val hm = HashMap<Int, Int>()
    for (s in readln().split(' ')) {
        val m = s.toInt()
        if (m !in hm) hm[m] = 0
        hm[m] = hm[m]!! + 1
    }

    readln()

    print(
        buildString {
            for (s in readln().split(' ')) {
                append(hm[s.toInt()] ?: 0).append(' ')
            }
        }
    )
}
