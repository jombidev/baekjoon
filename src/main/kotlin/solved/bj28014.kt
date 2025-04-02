fun main() {
    val ln = readln().toInt()
    var l = 1
    val m = readln().split(' ').map { it.toInt() }
    for (i in 0..<ln-1) {
        if (m[i] <= m[i + 1]) l++
    }
    print(l)
}
