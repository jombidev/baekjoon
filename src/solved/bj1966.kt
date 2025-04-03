fun main() {
    repeat(readln().toInt()) {_->
        var (N, M) = readln().split(' ').map { it.toInt() }
        val q = ArrayDeque(readln().split(' ').mapIndexed { i, it -> i to it.toInt() })
        N = 0

        while (q.isNotEmpty()) {
            val i = q.removeFirst()
            if (q.any { it.second > i.second }) {
                q.add(i)
                continue
            }
            N++

            if (M == i.first)
                println(N)
        }
    }
}
