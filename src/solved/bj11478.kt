fun main() {
    val m = readln()
    val s = HashSet<String>(m.length + m.length / 2 + 1)
    for (i in 1 ..m.length) {
        for (j in 0..m.length-i) {
            s.add(m.substring(j, j+i))
        }
    }
    print(s.size)
}
