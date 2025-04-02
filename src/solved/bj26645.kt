fun main() {
    val i = readln().toInt()
    val l = arrayListOf<Pair<Int, Int>>()
    val c = arrayOf(209 to 8, 219 to 4, 229 to 2, 285 to 1)
    for (j in c.indices) {
        var baseLv = i
        val (max, z) = c[j]
        if (max < baseLv) continue
        for (k in 0 until z) {
            if (max < baseLv) break
            baseLv++
        }
        l.add(j + 1 to baseLv)
    }
    print(l.maxBy{it.first+it.second}.first)
}
