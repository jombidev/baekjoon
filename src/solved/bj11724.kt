fun main() {
    val (n, m) = readln().ints()
    val o = HashMap<Int, MutableList<Int>>()
    val v = Array(n) { false }
    for (i in 0 ..< m) {
        val (a, b) = readln().split(" ").map { it.toInt() - 1 }
        if (o[a] == null) o[a] = ArrayList()
        o[a]!!.add(b)

        if (o[b] == null) o[b] = ArrayList()
        o[b]!!.add(a)
    }

    var count = 0

    for (i in 0..< n) {
        if (v[i]) continue
        if (o[i] == null) {
            count++
            continue
        }

        val q = ArrayList<Int>()
        q.add(i)
        while (q.isNotEmpty()) {
            for (j in o[q.removeFirst()]!!) {
                if (!v[j]) {
                    v[j] = true
                    q.add(j)
                }
            }
        }

        count++
    }

    print(count)
}

private fun String.ints() = split(" ").map { it.toInt() }
