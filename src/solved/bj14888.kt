var max = Int.MIN_VALUE
var min = Int.MAX_VALUE
fun main() {
    readln()
    val nums = readln().split(' ').map { it.toInt() }
    val (p, m, t, d) = readln().split(' ').map { it.toInt() }

    nums.bt(nums[0], 1, p, m, t, d)

    println(max)
    println(min)
}

fun List<Int>.bt(num: Int, i: Int, p: Int, m: Int, t: Int, d: Int) {
    if (i == size) {
        if (num < min)
            min = num
        if (num > max)
            max = num
        return
    }

    val r = this[i]

    if (p != 0) bt(num + r, i + 1, p - 1, m, t, d)
    if (m != 0) bt(num - r, i + 1, p, m - 1, t, d)
    if (t != 0) bt(num * r, i + 1, p, m, t - 1, d)
    if (d != 0) bt(num / r, i + 1, p, m, t, d - 1)
}
