fun main() {
    val n = readln().toInt()
    readln()

    val s = readln()
    var c = 0
    var i = 0
    var t = 0
    do {
        val pi = i
        i = s.indexOf("IOI", pi) + 1

        if (i == 0)
            break
        else if (i - pi == 2) {
            t++

            if (n <= t)
                c++
        } else {
            t = 1

            if (n <= t)
                c++
        }
    } while (true)
    println(c)
}
