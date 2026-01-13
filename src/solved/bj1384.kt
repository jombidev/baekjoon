import java.util.LinkedList

fun main() {
    val ln = LinkedList(System.`in`.bufferedReader().readLines())

    var g = 1
    while (true) {
        val n = ln.removeFirst().toInt()
        if (n == 0) break
        println("Group ${g++}")

        val rn = Array(n) { ln.removeFirst().split(' ') }
        var bad = false

        for ((me, arr) in rn.withIndex()) {
            for ((i, p) in arr.drop(1).withIndex()) {
                if (p[0] == 'N') {
                    println("${rn[(me + (n - i - 1)) % n][0]} was nasty about ${arr[0]}")
                    bad = true
                }
            }
        }

        if (!bad) println("Nobody was nasty")
        println()
    }
}
