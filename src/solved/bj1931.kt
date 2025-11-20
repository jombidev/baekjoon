fun main() {
    val n = readln().toInt()
    var count = 1
    val h = List(n) {
        val (s, e) = readln().split(' ').map { it.toInt() }
        s to e
    }.sortedWith(Comparator.comparingInt<Pair<Int, Int>> { it.second }.thenComparingInt { it.first })

    var end = h[0].second

    for (i in 1..<h.size) {
        if (end <= h[i].first) {
            end = h[i].second
            count++
        }
    }

    print(count)
}
