fun main() {
    val t = readln()
    val m = MutableList(10) { scan -> t.count { it - '0' == scan } }

    val sixNine = m.removeAt(6) + m.removeAt(8)
    m.add(sixNine / 2 + sixNine % 2)

    print(m.max())
}
