fun main() {
    val (N, M) = readln().split(' ').map { it.toInt() }
    val ktv = HashMap<String, Int>(N)
    val vtk = HashMap<Int, String>(N)

    repeat(N) {
        val read = readln()
        ktv[read] = it + 1
        vtk[it + 1] = read
    }

    repeat(M) {
        val str = readln()
        println(str.toIntOrNull()?.let { vtk[it] } ?: ktv[str])
    }
}
