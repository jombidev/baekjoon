fun main() {
    readln()
    val q = readln().split(' ').map { it.toInt() }.toIntArray()

    var l = 0
    var r = q.lastIndex

    var minDiff = Triple(-1, -1, Int.MAX_VALUE)

    while (l < r) {
        val diff = q[l] + q[r]

        if (diff == 0) {
            return print("${q[l]} ${q[r]}")
        }

        if (minDiff.third > Math.abs(diff))
            minDiff = Triple(q[l], q[r], Math.abs(diff))

        if (diff > 0) r--
        else l++
    }

    print("${minDiff.first} ${minDiff.second}")
}
