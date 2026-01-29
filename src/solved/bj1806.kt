fun main() {
    val (n, s) = readln().split(' ').map { it.toInt() }
    val w = readln().split(' ').map { it.toInt() }.toIntArray()

    var l = 0
    var r = 0
    var ps = 0L
    var ml = Int.MAX_VALUE

    while (r < n) {
        if (ps < s) {
            ps += w[r++]
        } else {
            ml = minOf(ml, r - l)
            if (ml == 1) break
            ps -= w[l++]
        }
    }
    while (ps >= s) {
        ml = minOf(ml, r - l)
        if (ml == 1) break
        ps -= w[l++]
    }

    print(if (ml != Int.MAX_VALUE) ml else 0)
}
