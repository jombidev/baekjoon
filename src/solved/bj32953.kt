fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }

    val h = HashMap<String, Int>()
    repeat(n) {
        readln()
        for (s in readln().split(' ')) {
            h[s] = h.getOrDefault(s, 0) + 1
        }
    }

    print(h.filter { it.value >= m }.size)
}
