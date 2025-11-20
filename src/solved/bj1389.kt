const val M = Int.MAX_VALUE
fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val r = List(m) { readln().split(' ').map { it.toInt() } }

    val hm = HashMap<Int, MutableSet<Int>>()
    for ((a, b) in r) {
        val ar = hm.getOrPut(a - 1) { LinkedHashSet() }
        val br = hm.getOrPut(b - 1) { LinkedHashSet() }
        ar.add(b - 1)
        br.add(a - 1)
    }

    val fm = Array(n) { Array(n) { M } }
    for (i in 0..<n)
        fm[i][i] = 0

    for (i in 0..<n)
        fm.bfs(i, hm)

    print(fm.indexOf(fm.minBy { it.sum() }) + 1)
}

fun Array<Array<Int>>.bfs(me: Int, l: Map<Int, Set<Int>>) {
    data class FrenDepth(val t: Int, val depth: Int)
    for (fn in 0..<size) {
        if (fn == me) continue
        if (this[me][fn] != M || this[fn][me] != M) {
            val min = minOf(this[me][fn], this[fn][me])
            this[me][fn] = min
            this[fn][me] = min
            continue
        }

        val vm = BooleanArray(size)
        val ll = java.util.LinkedList<FrenDepth>()
        ll.add(FrenDepth(me, 0))

        b@while (ll.isNotEmpty()) {
            val fm = ll.removeFirst()
            if (vm[fm.t])
                continue
            vm[fm.t] = true

            for (i in l[fm.t] ?: continue) {
                if (i == fn) {
                    this[me][fn] = fm.depth + 1
                    this[fn][me] = fm.depth + 1
                    break@b
                }

                ll.add(FrenDepth(i, fm.depth + 1))
            }
        }
    }
}
