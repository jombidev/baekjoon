fun main() {
    val s = readln().split(' ').map { it.toInt() }
    print(if (s == s.sorted()) "ascending" else if (s == s.sortedDescending()) "descending" else "mixed")
}
