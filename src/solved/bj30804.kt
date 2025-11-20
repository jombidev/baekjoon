fun main() {
    val n = readln().toInt()
    val s = readln().split(' ').map { it.toInt() }.toIntArray()
    val m = LinkedHashMap<Int, Int>()

    var l = 0
    var r = 0
    var ml = 0

    while (l <= r && r < n) {
        if (m.size > 2) {
            m[s[l]] = m[s[l]]!! - 1
            if (m[s[l]] == 0)
                m.remove(s[l])
            l++
        } else {
            ml = maxOf(ml, m.values.sum())
            m[s[r]] = (m[s[r]] ?: 0) + 1
            r++
        }
    }
    while (m.size > 2) {
        m[s[l]] = m[s[l]]!! - 1
        if (m[s[l]] == 0)
            m.remove(s[l])
        l++
    }
    ml = maxOf(ml, m.values.sum())
    print(ml)
}
