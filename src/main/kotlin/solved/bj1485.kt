package solved

fun main() {
    for (i in 0 until  readln().toInt()) {
        val points = List(4) { readln().split(' ').map { it.toInt() + 100000 } }
        val minX = points.minOf { it[0] }
        val minY = points.minOf { it[1] }
        val pMap = points.sortedBy { it[0]+it[1] }.map { listOf(it[0] - minX, it[1] - minY) }
        val ps = pMap.map { it.sorted() }
        println(if (pMap.any { it.all { it == 0 } }) {
            if (ps[1] == ps[2]) 1 else 0
        } else {
            if (ps[0] == ps[1] && ps[2] == ps[3]) 1 else 0
        })
    }
}