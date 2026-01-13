fun main() {
    val n = readln().toInt()
    val sb = StringBuilder()
    fun w(k: Int) {
        for (i in 1..n)
            sb.append("@".repeat(k)).append('\n')
    }
    w(n * 5)
    w(n)
    w(n * 5)
    w(n)
    w(n)
    print(sb)
}
