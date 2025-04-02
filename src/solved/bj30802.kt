fun main() {
    val a = readln().toInt()
    val sz = readln().split(' ').map { it.toInt() }
    val (t, p) = readln().split(' ').map { it.toInt() }
    print("${sz.sumOf { Math.ceil(it.toDouble() / t).toInt() }}\n${a / p} ${a % p}")
}
