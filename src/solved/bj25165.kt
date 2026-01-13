fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() - 1 }
    val (ac, d) = readln().split(' ').map { it.toInt() }
    val (sr, sc) = readln().split(' ').map { it.toInt() - 1 }

    for (i in 0..n) {
        val caught = if (i == 0) {
            sc in ac..m && sr == 0
        } else if (i != n) {
            sc in 0..m && sr == i
        } else {
            if (n % 2 == d) false else sc in 0..m && sr == i
        }

        if (caught) return print("NO...")
    }

    print("YES!")
}
