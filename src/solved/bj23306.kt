fun flush() = System.out.flush()
fun main() {
    val n = readln()

    println("? 1")
    flush()
    val f = readln() == "0"

    println("? $n")
    flush()
    val l = readln() == "0"

    println(if (f == l) "! 0" else if (f) "! 1" else "! -1")
}
