package solved

fun main() = with(StringBuilder()) {
    val i = readln().toInt() - 1
    for (j in 0 .. i) {
        for (k in 0 .. i) {
            append(if (j == 0 || k == 0 || j == i || k == i || j == k || i - j == k) '*' else ' ')
        }
        append('\n')
    }
    print("$this")
}