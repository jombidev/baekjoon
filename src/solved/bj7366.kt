fun main() = repeat(readln().toInt()) {
    readln()
    println("Case ${it + 1}: This list contains ${readln().split(' ').count { it == "sheep" }} sheep.\n")
}
