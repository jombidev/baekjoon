fun main() {
    readln()

    val t = IntArray(80001)
    val s = IntArray(80001)

    t[3] = 3
    s[7] = 7

    for (i in 6..80000 step 3) t[i] = t[i - 3] + i
    for (i in 14..80000 step 7) s[i] = s[i - 7] + if (i % 3 == 0) 0 else i

    for (i in readln().split(' ').map { it.toInt() }) {
        var sum = 0
        for (n in i - 2 .. i)
            if (t[n] != 0)
                sum += t[n]
        for (n in i - 6 .. i)
            if (s[n] != 0)
                sum += s[n]

        println(sum)
    }
}
