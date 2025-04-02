fun main() {
    var (a, b, max) = readln().split(" ").map { it.toInt() }.sorted()
    if (a + b <= max) max -= max - a - b + 1
    print(a + b + max)
}
