import java.util.StringTokenizer

fun main() = System.`in`.bufferedReader().use {
    fun r() = it.readLine()
    fun StringTokenizer.l() = nextToken().toLong()

    val sb = StringBuilder()

    val n = r().toInt()
    val d = Array(n) { LongArray(3) }

    repeat(n) {
        val st = StringTokenizer(r(), " ")

        d[it][0] = st.l()
        d[it][1] = st.l()
        d[it][2] = st.l()
    }

    repeat(r().toInt()) {
        val st = StringTokenizer(r(), " ")
        val x1 = st.l()
        val y1 = st.l()
        val z1 = st.l()
        val r = st.l()
        var c = 0

        for ((x2, y2, z2) in d) {
            val dx = x1 - x2
            val dy = y1 - y2
            val dz = z1 - z2

            if (dx * dx + dy * dy + dz * dz <= r * r) c++
        }

        sb.append(c).append('\n')
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
    }
}
