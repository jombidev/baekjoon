fun main() {
    val (N, K) = readln().split(' ').map { it.toInt() }
    val target = Array(N * K) { Array(N * K) { 0 } }

    repeat(N) { y ->
        val e = readln().split(' ').map { it.toInt() }
        repeat(N) {
            for (i in 0..<K) for (j in 0..<K)
                target[y * K + j][it * K + i] = e[it]
        }
    }
    for (ints in target)
        println(ints.joinToString(" "))
}
