fun main() {
    val countX = hashSetOf<Int>()
    val countY = hashSetOf<Int>()
    repeat(3) {
        val (x, y) = readln().split(' ').map { it.toInt() }
        if (x in countX) countX.remove(x)
        else countX.add(x)
        if (y in countY) countY.remove(y)
        else countY.add(y)
    }
    print("${countX.first()} ${countY.first()}")
}
