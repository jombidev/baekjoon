package solved

fun main() {
    val p = "..#..\n.#.#.\n#.\\.#\n.#.#.\n..#.."
    val l = readln()
    val t = Array(5) { Array(l.length * 4 + 1) { '.' } }
    for ((i, c) in l.withIndex()) {
        var m = p
        if (i % 3 == 2) m = m.replace("#", "*")
        for ((a, s) in m.replace('\\', c).split('\n').withIndex()) {
            for ((b, h) in s.withIndex()) {
                if (t[a][i * 4 + b] != '*') t[a][i * 4 + b] = h
            }
        }
    }
    println(t.joinToString("\n") { it.joinToString("") })
}