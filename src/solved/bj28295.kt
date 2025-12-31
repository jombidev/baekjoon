fun main() {
    var r = 0
    repeat(10) {
        r += readln().toInt().let { if (it == 3) -1 else it }
        if (r < 0) r += 4
        r %= 4
    }

    print("NESW"[r])
}
