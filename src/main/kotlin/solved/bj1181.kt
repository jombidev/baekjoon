fun main() {
    print(List(readln().toInt()) { readln() }.distinct().sorted().sortedBy { it.length }.joinToString("\n"))
}
