fun main() = System.`in`.bufferedReader().use { r ->
    val (i, o) = r.readLine().split(' ').map { it.toInt() }
    val m = List(i) { r.readLine().split(' ').let { it[0] to it[1] } }.toMap()
    repeat(o) {
        println(m[r.readLine()]!!)
    }
}
