package fail

import kotlin.streams.toList

fun main() {
    print(List(readln().toInt()) { readln() }.distinct().sortedBy { it.length + it.codePoints().toList().let {
        val len = it.size.toDouble()
        it.mapIndexed { i, offset -> (len - i.toDouble()) / len * offset.toDouble() / 'z'.code }.sum()
    } }.joinToString("\n"))
}