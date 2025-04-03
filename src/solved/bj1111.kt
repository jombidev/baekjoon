fun main() {
    val size = readln().toInt()
    if (size < 2) return print("A")

    val arr = readln().split(' ').map { it.toInt() }
    if (arr.toSet().size == 1) return print(arr.first())
    if (size <= 2) return print("A")

    val cases = hashSetOf<Pair<Int, Int>>()

    for (i in 0..<size - 2) {
        val minor = hashSetOf<Pair<Int, Int>>()
        for (a in 0..200) {
            // arr[2] == arr[1] * a + b
            // arr[1] == arr[0] * a + b
            // arr[1] - arr[0] * a == b
            // System of linear equations method
            if (arr[i + 2] == arr[i + 1] * a + arr[i + 1] - arr[i + 0] * a)
                minor.add(a to arr[i + 1] - arr[i + 0] * a)
            if (arr[i + 2] == arr[i + 1] * -a + arr[i + 1] - arr[i + 0] * -a)
                minor.add(-a to arr[i + 1] - arr[i + 0] * -a)
        }
        cases.removeIf { it !in minor }
        if (i == 0) cases.addAll(minor)
    }

    val fi = arr.last()
    val m = cases.map { fi * it.first + it.second }.toSet()
    if (m.isEmpty()) print("B")
    else print(m.singleOrNull() ?: "A")
}

// FULL-BRUTEFORCE - timeout
//fun main() {
//    val sz = readln().toInt()
//    if (sz < 2) return print("A")
//
//    val arr = readln().split(' ').map { it.toInt() }
//    val hs = hashSetOf<Pair<Int, Int>>()
//    for (i in 0..<sz - 1) {
//        val m = hashSetOf<Pair<Int, Int>>()
//        for (j in 0..<200) {
//            for (k in 0..<20100) {
//                if (arr[i] * j + k == arr[i + 1]) m.add(j to k)
//                if (arr[i] * j + -k == arr[i + 1]) m.add(j to -k)
//                if (arr[i] * -j + k == arr[i + 1]) m.add(-j to k)
//                if (arr[i] * -j + -k == arr[i + 1]) m.add(-j to -k)
//            }
//        }
//        hs.removeIf { it !in m }
//        if (i == 0) hs.addAll(m)
//    }
//    val fi = arr.last()
//    val m = hs.map { fi * it.first + it.second }.toSet()
//    if (m.isEmpty()) print("B")
//    else print(m.singleOrNull() ?: "A")
//}
