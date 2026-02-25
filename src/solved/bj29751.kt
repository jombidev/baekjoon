fun main() {
    val (w, h) = readln().split(' ').map { it.toInt() }
    print("%.1f".format(w * h / 2.0))
}
