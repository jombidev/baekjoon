fun main() {
    val m = HashSet<String>()
    for ((n, e) in List(readln().toInt()) { readln().split(' ') }) {
        if (e[0] == 'e') {
            m.add(n)
        } else {
            m.remove(n)
        }
    }
    m.sortedDescending().forEach(::println)
}
