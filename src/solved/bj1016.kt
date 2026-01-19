fun main() {
    val (min, max) = readln().split(' ').map { it.toLong() }

    val v = BooleanArray((max - min + 1).toInt())

    for (i in 2..Math.ceil(Math.sqrt(max + .0)).toLong()) {
        for (n in Math.ceil((min + .0) / (i * i)).toLong() * i * i..max step i * i) {
            v[(n - min).toInt()] = true
        }
    }

    print(v.count { !it })
}
