package solved

fun main() = readln().let { repeat(26) { i -> print("${it.count { 'a' + i == it }} ") } }
