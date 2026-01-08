import java.util.LinkedList

typealias PII = Pair<Int, Int>

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    class K(var z: Int, val h: Int)

    val map = Array(n) { IntArray(m) }
    val zs = Array(n) { Array<K?>(m) { null } }
    val spc = LinkedHashSet<PII>()

    for (y in 0..<n) {
        val k = readln()
        for (x in 0..<m) {
            map[y][x] = k[x] - '0'
            if (map[y][x] == 0)
                spc.add(x to y)
        }
    }

    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)
    var nextHash = 0

    while (spc.isNotEmpty()) {
        val ll = LinkedList<PII>()
        val f = spc.first()
        ll.add(f)
        spc.remove(f)
        val k = K(1, nextHash++)

        while (ll.isNotEmpty()) {
            val (x, y) = ll.removeFirst()

            zs[y][x] = k // shared instance

            for (i in 0..<4) {
                val ox = x + dx[i]
                val oy = y + dy[i]

                if (ox !in 0..<m || oy !in 0..<n || ox to oy !in spc)
                    continue

                spc.remove(ox to oy)
                k.z++

                ll.add(ox to oy)
            }
        }
    }

    val sb = StringBuilder()

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (map[i][j] == 0)
                sb.append(0)
            else {
                val s = hashSetOf<Int>()
                var d = 1

                for (k in 0..<4) {
                    val ox = j + dx[k]
                    val oy = i + dy[k]

                    if (ox !in 0..<m || oy !in 0..<n || zs[oy][ox] == null || zs[oy][ox]!!.h in s)
                        continue

                    val k = zs[oy][ox]!!
                    s.add(k.h)

                    d += k.z
                }

                sb.append(d % 10)
            }
        }
        sb.appendLine()
    }

    print(sb)
}
