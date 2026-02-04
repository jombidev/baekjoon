fun main() {
    val a = Array(3) { readln().toInt() * (3 - it) }.sum()
    val b = Array(3) { readln().toInt() * (3 - it) }.sum()

    print(if (a > b) 'A' else if (a < b) 'B' else 'T')
}
