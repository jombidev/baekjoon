fun main() {
    val r = Regex("(100+1+|01)+")
    repeat(readln().toInt()) {
        println(if (readln().matches(r)) "YES" else "NO")
    }
}
