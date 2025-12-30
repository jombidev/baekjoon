fun main() {
    val n = readln().split('|')
    val s = n.sumOf {
        when (it[0]) {
            in "CFG" -> 1L
            in "ADE" -> -1L
            else -> 0L
        }
    }
    print(
        when {
            s == 0L -> if (n.last().last() in "CFG") "C-major" else "A-minor"
            s > 0 -> "C-major"
            else -> "A-minor"
        }
    )
}
