fun main() {
    var r = readln().toInt()
    for (i in 666..6_660_000) {
        if (i.toString().contains("666") && --r == 0)
            return print(i)
    }
}
