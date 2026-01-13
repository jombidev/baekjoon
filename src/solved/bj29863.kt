fun main() {
    val n = readln().toInt().let { if (it > 3) it - 24 else it }
    val a = readln().toInt()

    print(a - n)
}
