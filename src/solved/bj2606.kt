fun main() {
    val links = HashMap<Int, MutableList<Int>>()
    val pc = readln().toInt()
    repeat(readln().toInt()) {
        val (a, b) = readln().split(' ').map { it.toInt() }
        if (a !in links) links[a] = arrayListOf()
        if (b !in links) links[b] = arrayListOf()
        links[a]!!.add(b)
        links[b]!!.add(a)
    }

    val q = ArrayDeque<Int>()
    val v = Array(pc + 1) { false }
    q.add(1) // initial
    while (q.isNotEmpty()) {
        val t = q.removeFirst()
        if (!v[t]) {
            v[t] = true
            links[t]?.let { q.addAll(it) }
        }
    }
    print(v.count { it } - 1)
}
