fun main() {
    val l = readln().toInt()
    var d = 0
    val target = List(l) { readln().toInt() }
    val dest = ArrayDeque<Int>()
    val sb = StringBuilder()

    for (i in 1..l) {
        dest.add(i)
        sb.append('+').append('\n')

        while (d < l && target[d] == dest.lastOrNull()) {
            dest.removeLast()
            sb.append('-').append('\n')
            d++
        }
    }

    print(if (dest.isEmpty()) sb else "NO")
}
