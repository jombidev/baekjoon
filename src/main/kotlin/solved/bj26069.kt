fun main() {
    val visitSet = hashSetOf("ChongChong")
    for (i in 0..<readln().toInt()) {
        val (n, m) = readln().split(' ')
        if (visitSet.contains(n) && !visitSet.contains(m)) visitSet.add(m)
        if (!visitSet.contains(n) && visitSet.contains(m)) visitSet.add(n)
    }
    print(visitSet.size)
}
