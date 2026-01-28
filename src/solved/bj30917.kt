fun flush() = System.out.flush()
fun main() {
    fun guess(c: Char): Int {
        for (i in 1..9) {
            println("? $c $i")
            flush()
            if (readln() == "1")
                return i
        }

        return 0
    }

    val a = guess('A')
    val b = guess('B')

    println("! ${a + b}")
    flush()
}
