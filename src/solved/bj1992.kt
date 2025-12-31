fun main() {
    val n = readln().toInt()
    val p = Array(n) { readln().map { it - '0' }.toIntArray() }

    fun dnc(x: Int, y: Int, s: Int): String {
        if (s == 1) return p[y][x].toString()

        val o = s / 2
        val a = Array(2) { Array(2) { "" } }
        for (oy in 0..1) {
            for (ox in 0..1) {
                val dx = ox * o + x
                val dy = oy * o + y

                val n = dnc(dx, dy, o)
                a[oy][ox] = n
            }
        }

        val f = a.flatten()
        var ao = true
        var az = true

        for (string in f) {
            if (string != "1")
                ao = false
            if (string != "0")
                az = false
        }

        return when {
            ao -> "1"
            az -> "0"
            else -> f.joinToString("") { if (it.length == 1) it else "($it)" }
        }
    }

    val r = dnc(0, 0, n)
    print(if (r.length == 1) r else "($r)")
}
