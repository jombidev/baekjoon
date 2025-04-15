fun main() {
    var (high, target) = readln().split(' ').map { it.toLong() }
    high = 0
    val d = readln().split(' ').map { it.toLong().also { high = maxOf(it, high) } }
    var low = 0L
    var mid = 0L

    while (low <= high) {
        mid = (low + high).ushr(1)
        val midVal = d.sumOf { (it - mid).takeIf { it > 0 } ?: 0 }
        if (midVal == 0L)
            break

        if (midVal > target)
            low = mid + 1
        else if (midVal < target) {
            high = mid - 1
        }
        else break
    }
    for (i in mid downTo mid - 1) {
        val midVal = d.sumOf { (it - i).takeIf { it > 0 } ?: 0 }
        if (midVal >= target) return print(i)
    }
}
