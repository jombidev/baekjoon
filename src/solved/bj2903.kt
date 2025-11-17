fun main() {
    var n = 2

    repeat(readln().toInt()) {
        n += n - 1
    }

    print(n * n)
}
