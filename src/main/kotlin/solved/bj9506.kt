package solved

fun main() {
    while (true) {
        val sums = ArrayList<Int>()
        val n = readln().toInt()
        if (n == -1) System.exit(0)
        for (i in 1..n / 2 + 2) {
            if (n % i == 0) {
                sums.add(i)
            }
        }
        println(if (sums.sum() == n) "$n = ${sums.joinToString(" + ")}" else "$n is NOT perfect.")
    }
}