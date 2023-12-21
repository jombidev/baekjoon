package solved

fun main() {
    val (N, M, V) = readln().split(' ').map { it.toInt() }
    val starlink = Array(M) { readln().split(' ').map { it.toInt() }.let { it[0] to it[1] } }
    val j = Array(N) { J(LinkedHashSet()) }
    val d = LinkedHashSet<Int>()
    for ((i, l) in starlink) {
        j[i].js.add(j[l])
        j[l].js.add(j[i])
    }
    val q = ArrayDeque<J>()
    val visited = Array(N) { false }
    q.add(j[V])
    visited[V] = true
    while (q.isNotEmpty()) {
        val (js) = q.removeFirst()
        for (tamsek in js) {

        }
    }
}
data class J(val js: LinkedHashSet<J>)