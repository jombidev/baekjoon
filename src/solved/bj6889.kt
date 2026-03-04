fun main() {
    val n = readln().toInt()
    val m = readln().toInt()

    val adj = Array(n) { readln() }
    val noun = Array(m) { readln() }

    for (i in adj)
        for (j in noun)
            println("$i as $j")
}
