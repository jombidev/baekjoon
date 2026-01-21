fun main() {
    readln()
    print(readln().split(' ').filter { it.isNotBlank() }.sortedWith { a, b ->
        val aFirst = "$a$b".toBigInteger()
        val bFirst = "$b$a".toBigInteger()
        bFirst.compareTo(aFirst)
    }.joinToString(" ").trim())
}
