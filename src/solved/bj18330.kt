fun main() {
    val u = readln().toInt()
    val q = readln().toInt() + 60

    print(if (q <= u) q * 1500 + (u - q) * 3000 else u * 1500)
}
