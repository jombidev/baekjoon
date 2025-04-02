fun main() {
    val t = readln().toInt()
    if (t < 2023) return print(0)
    var c = 1
    r@for (i in 2024..t) {
        val taken = i.toString()
        var dx = 0
        for (j in "2023") {
            dx = taken.indexOf(j, dx)
            if (dx == -1) continue@r
        }
        c++
    }
    print(c)
}
