fun main() = if (readln() == "1") step1() else step2()
val map = ('a'..'z').toList()

fun step1() {
    val res = readln().split(' ').sumOf { it.toLong() }
    println(res.toString(26).map { map[it.digitToInt(26)] }.joinToString("").padStart(13, 'a'))
}

fun step2() {
    println(readln().map { map.indexOf(it).toString(26) }.joinToString("").toLong(26))
}
