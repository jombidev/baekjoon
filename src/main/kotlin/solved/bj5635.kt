package solved

import java.time.LocalDate

fun main() {
    val b = List(readln().toInt()) {
        readln().split(' ').let { Birth(it[0], LocalDate.of(it[3].toInt(), it[2].toInt(), it[1].toInt())) }
    }

    println(b.maxBy { it.d }.name)
    println(b.minBy { it.d }.name)
}

class Birth(val name: String, val d: LocalDate)