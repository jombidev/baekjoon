fun main() {
    val (src, dst) = readln().split(' ').map { it.toLong() }

    val ll = java.util.LinkedList<Pair<Long, Int>>()
    ll.add(src to 1)

    while (ll.isNotEmpty()) {
        val (n, t) = ll.removeFirst()

        if (dst == n)
            return print(t)

        if (dst < n)
            continue

        ll.add(n * 2 to t + 1)
        ll.add(n * 10 + 1 to t + 1)
    }

    print(-1)
}
