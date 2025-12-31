fun main() {
    readln()

    var l = false
    var md = false
    var ph = 0

    for (ch in readln()) {
        if (ch == 'W') {
            ph++
            if (ph == 2) {
                return print(if (md) 6 else if (l) 1 else 5)
            }
        } else if (ch == 'P') {
            l = !l
            if (ph == 1) md = true
        }
    }
    print(0)
}
