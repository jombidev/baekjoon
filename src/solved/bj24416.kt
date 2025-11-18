fun main() {
    val n = readln().toInt()
    val arr = IntArray(n + 1)
    arr[1] = 1
    arr[2] = 1
    for (i in 3 .. n) {
        arr[i] = arr[i - 1] + arr[i - 2]
    }
    println("${arr[n]} ${n - 2}")
}
