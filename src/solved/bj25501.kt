fun main() {
    repeat (readln().toInt()) {
        println(p(readln()).run { "$first $second" })
    }
}

fun p(s: String, i: Int = 0, r: Int = 0): Pair<Int, Int> {
    if (s.length / 2 + 1 <= i)
        return 1 to r

    if (s[i] != s[s.lastIndex - i])
        return 0 to r + 1

    return p(s, i + 1, r + 1)
}
