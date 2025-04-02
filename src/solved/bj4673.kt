fun main() = repeat(10000) { if (b(it + 1)) println(it + 1) }
fun b(e: Int): Boolean {
    for (i in 1..e) {
        var (j, k) = i to 0;while (j != 0) {
            k += j % 10;j /= 10
        };if (i + k == e) return false
    };return true
}
