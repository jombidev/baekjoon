import kotlin.math.roundToInt

fun main() {
    val sz = readln().toInt()
    if (sz == 0) return print(0)
    val scores = List(sz) { readln().toInt() }
    val toDelete = (sz.toDouble() * 0.15).roundToInt()
    println(scores.sorted().let { it.slice(toDelete..it.lastIndex - toDelete) }.average().roundToInt())
}
