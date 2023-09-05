fun main() {
    println(System.`in`.bufferedReader().readLines().map { it.split(' ') }.flatten()
        .sortedByDescending { it.toBigInteger() - it.count { it == '0' }.toBigInteger() }.joinToString("")
    )
}