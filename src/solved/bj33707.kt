fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }

    for (i in 0..<n) {
        for (j in (i + 1) % 2..<m step 2) {
            println("? ${i + 1} ${j + 1}")
            System.out.flush()
            if (readln() == "1")
                return
        }
    }
}
