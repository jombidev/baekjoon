fun main() {
    var (a, b, c) = readln().split(' ').map { it.toLong() }
    var t = 1L
    while (b > 0) {
        if (b and 1 == 1L) {
            t = (t * a) % c
        }
        a = (a * a) % c
        b = b shr 1
    }
    print(t)
}
