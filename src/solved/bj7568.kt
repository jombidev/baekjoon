fun main() {
    val sz = readln().toInt()
    val ds = List(sz) { readln().split(' ').map { it.toInt() } }
    val c = Array(sz) { 1 }
    for (target in ds) {
        for ((i, com) in ds.withIndex()) {
            if (target[0] > com[0] && target[1] > com[1])
                c[i]++
        }
    }
    c.forEach(::println)
}
