fun main() {
    val b = readln()

    fun calc(a: String) = (0..3).sumOf { i -> (a[i] - b[i]) * (a[i] - b[i]) } * (4..5).sumOf { i -> (a[i] - b[i]) * (a[i] - b[i]) } * (6..7).sumOf { i -> (a[i] - b[i]) * (a[i] - b[i]) }

    val n = readln().toInt()
    val v = Array(n) { readln() }
    v.sortWith(compareBy<String> { -calc(it) }.thenBy { it.toInt() })

    print(v[0])
}
