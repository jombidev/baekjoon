fun main() {
    val (n, c) = readln().split(' ').map { it.toInt() }
    val w = readln().split(' ').map { it.toInt() }

    fun total(l: Int, r: Int): List<Int> {
        val sums = ArrayList<Int>()

        fun combination(i: Int, s: Int) {
            if (s > c) return
            if (i >= r) {
                sums.add(s)
                return
            }

            combination(i + 1, s)
            combination(i + 1, s + w[i])
        }
        combination(l, 0)

        return sums.sorted()
    }

    val m = n.ushr(1)
    val lPtr = total(0, m)
    val rPtr = total(m, n)
    var sum = 0

    var l = 0
    var r = rPtr.size - 1

    while (l < lPtr.size && r >= 0) {
        if (lPtr[l] + rPtr[r] <= c) {
            sum += r + 1
            l++
        } else {
            r--
        }
    }

    print(sum)
}
