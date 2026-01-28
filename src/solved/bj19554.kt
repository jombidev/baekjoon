fun main() {
    var min = 1
    var max = readln().toInt()

    var tries = 50

    while (tries-- > 0) {
        val mid = min + (max - min).ushr(1)
        println("? $mid")
        System.out.flush()

        val res = readln()
        when (res) {
            "0" -> return println("= $mid")
            "1" -> max = mid - 1
            else -> min = mid + 1
        }
    }
}
