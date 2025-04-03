fun main() {
    val m = List(readln().toInt()) { readln().toShort() }
    val c = HashMap<Short, Int>()

    var sum = 0.0
    var max = Short.MIN_VALUE
    var min = Short.MAX_VALUE
    for (e in m) {
        sum += e
        if (e !in c) c[e] = 0
        c[e] = c[e]!! + 1
        max = maxOf(max, e)
        min = minOf(min, e)
    }
    println(Math.round(sum / m.size).toInt())
    println(m.sorted()[m.size / 2])
    val mc = c.toList().sortedWith(compareBy<Pair<Short, Int>> { -it.second }.thenComparingInt { it.first.toInt() })
    println(if (mc[0].second == mc.getOrNull(1)?.second) mc[1].first else mc[0].first)
    println(max - min)
}
