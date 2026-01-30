fun main() {
    val m = Array(4) { readln().split(' ').map { it.toInt() }.toIntArray() }
    print(if (m.map { it.sum() }.distinct().size == 1 && m.indices.map { i -> m.indices.sumOf { m[i][it] } }.distinct().size == 1) "magic" else "not magic")
}
