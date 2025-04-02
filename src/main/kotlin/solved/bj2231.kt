fun main() {
    val t = readln().toInt()
    for (i in 1..t) {
        if (i.toString().sumOf { it-'0' } + i == t) return print(i)
    }
    print(0)
}
