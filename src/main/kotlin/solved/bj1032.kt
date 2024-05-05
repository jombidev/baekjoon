package solved

fun main() {
    val m = MutableList(readln().toInt()) { readln() }
    val v = m.removeAt(0).toCharArray()
    for (s in m)
        for (i in s.indices)
            if (s[i] != v[i]) v[i] = '?'
    print(v.joinToString(""))
}