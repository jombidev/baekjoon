fun flush() = System.out.flush()
fun main() {
    fun guess(c: Char): Int {
        val a = IntArray(10000) { it + 1 }
        a.shuffle()

        repeat(9999) {
            val n = a[it]
            println("? $c $n")
            flush()
            if (readln() == "1")
                return n
        }

        return a[9999]
    }

    val a = guess('A')
    val b = guess('B')

    println("! ${a + b}")
    flush()
}
