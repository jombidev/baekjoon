fun main() {
    val sz = readln().toInt()
    val m = List(sz) { readln().split(' ').let { Man(it[0].toInt(), it[1]) } }
    var cnt = 1
    m.sortedWith(
        Comparator.comparing<Man, Int> { it.old.also { cnt++ } }
            .thenComparingInt { cnt }
    ).forEach(::println)
}

data class Man(val old: Int, val name: String) {
    override fun toString(): String = "$old $name"
}
