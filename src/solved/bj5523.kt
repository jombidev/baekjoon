fun main() {
    val ab = System.`in`.bufferedReader().readLines()
    val w = IntArray(2)
    for (i in ab.indices) {
        if (i == 0 || ab[i].isEmpty()) continue
        val st = java.util.StringTokenizer(ab[i], " ")
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        if (a > b) w[0]++
        if (a < b) w[1]++
    }

    print(w.joinToString(" "))
}
