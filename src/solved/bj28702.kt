fun main() {
    val t = List(3) { readln() }
    val fn = t.indexOfFirst { it[0] in '0'..'9' }
    println(fizzbuzzfy(t[fn].toInt() + (3 - fn)))
}

fun fizzbuzzfy(i: Int) = buildString {
    if (i % 3 == 0) append("Fizz")
    if (i % 5 == 0) append("Buzz")
    if (isEmpty()) append(i)
}
