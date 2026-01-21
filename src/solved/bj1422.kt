fun main() {
    val (k, n) = readln().split(' ').map { it.toInt() }

    val nums = IntArray(n)

    var max = 0
    repeat(k) {
        nums[it] = readln().toInt()
        max = maxOf(max, nums[it])
    }

    for (i in 0..<n - k) nums[k + i] = max

    print(nums.sortedWith { a, b ->
        val aFirst = "$a$b".toBigInteger()
        val bFirst = "$b$a".toBigInteger()
        bFirst.compareTo(aFirst)
    }.joinToString("").trim())
}
