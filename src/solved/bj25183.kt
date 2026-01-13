fun main() {
    readln()
    val n = readln()
    var prev = n.first()
    var c = 0

    for (ch in n.drop(1)) {
        c = when (prev - ch) {
            1, -1 -> c + 1
            else -> 0
        }
        prev = ch
        if (c > 3) return print("YES")
    }
    print("NO")
}
