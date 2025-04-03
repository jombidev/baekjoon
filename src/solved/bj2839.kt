fun main() {
    var n = readln().toInt()
    var cnt = 0
    val cnts = HashSet<Int>()
    for (i in 0..n / 5) {
        var cpn = n
        var cpcnt = cnt
        for (j in 0..n / 3) {
            cpn -= 3
            cpcnt++
            if (cpn == 0)
                cnts.add(cpcnt)
        }
        n -= 5
        cnt++
        if (n == 0)
            cnts.add(cnt)
    }
    print(cnts.minOrNull() ?: -1)
}
