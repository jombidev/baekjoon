fun main() {
    val n = readln().toInt()
    print(n + (1..<n).count { it.toString().contains("50") })
}
