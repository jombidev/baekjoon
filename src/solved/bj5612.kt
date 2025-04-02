fun main() {
    val n = readln().toInt()
    var i = readln().toInt()
    var m = i
    repeat(n) {
        i += readln().split(' ').map { it.toInt() }.reduce(Int::minus)
        if (i < 0) return print(0)
        m = maxOf(i, m)
    }
    print(m)
}
