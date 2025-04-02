fun main() {
    readln()
    println(readln().split(' ').filter { it.isNotBlank() }.sortedWith { a, b ->
        val aFirst = "$a$b".toBigInteger()
        val bFirst = "$b$a".toBigInteger()
        if (aFirst >= bFirst) -1 else 1
    }.joinToString("").trim().toBigInteger())
}
