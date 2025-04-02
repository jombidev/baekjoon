fun main() {
    for (s in String(System.`in`.readBytes()).trimEnd().split('\n').dropLast(1)) {
        val (min, max) = s.split(' ').map { it.toInt() }
            println(if (min % max == 0) "factor"
            else if (max % min == 0) "multiple"
            else "neither")
    }
}
