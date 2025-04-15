fun main() = System.`in`.bufferedReader().use { r ->
    val (n, m) = r.readLine().split(' ').map { it.toInt() }
    val targ = r.readLine().split(' ').map { it.toInt() }
    val ps = Array(n) { targ[it] }
    for (i in 1..<n) {
        ps[i] += ps[i - 1]
    }
    repeat(m) {
        val (min, max) = r.readLine().split(' ').map { it.toInt() }
        var t = 0
        if (min - 2 >= 0) t -= ps[min - 2]
        t += ps[max - 1]
        println(t)
    }
}
