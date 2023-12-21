package solved

fun main() {
    val (n, k) = readln().split(' ').map { it.toInt() }
    var c = 0
    for (i in 1..n) {
        if (n % i == 0) {
            ++c
            if (k == c) {
                print(i)
                System.exit(0)
            }
        }
    }
    print(0)
}