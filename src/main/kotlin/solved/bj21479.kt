fun main() {
    print(String(System.`in`.readBytes()).split(Regex("\r?\n")).filter { it.isNotBlank() }.sortedWith { a, b ->
        val a = a.trim()
        val b = b.trim()
        val aFirst = "$a$b".toBigInteger()
        val bFirst = "$b$a".toBigInteger()
        if (aFirst >= bFirst) -1 else 1
    }.joinToString("").trim().toBigInteger())
}
