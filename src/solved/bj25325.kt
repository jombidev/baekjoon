fun main() {
    val n = readln().toInt()
    val s = readln().split(' ')
    val v = IntArray(n)

    repeat(n) {
        for (u in readln().split(' ')) v[s.indexOf(u)]++
    }

    var i = 0
    for ((e, a) in s.associateWith { v[i++] }.toList().sortedWith(compareBy<Pair<String, Int>> { -it.second }.thenBy { it.first }))
        println("$e $a")
}
