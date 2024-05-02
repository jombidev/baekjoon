package solved

fun main() {
    val t = readln().toInt()

    println(sy(List(t) {it + 1}.joinToString("")).joinToString("\n"))
}

private fun sy(str: String): List<String> {
    if (str.length == 1) return listOf(str)
    val mut = arrayListOf<String>()
    for (c in str.indices) {
        for (i in sy(str.removeRange(c..c))) {
            mut.add("${str[c]} $i")
        }
    }
    return mut
}