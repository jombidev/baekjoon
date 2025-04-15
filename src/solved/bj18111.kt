fun main() {
    val (y, x, inv) = readln().split(' ').map { it.toInt() }
    val floor = IntArray(x * y)
    var (min, max) = 0 to 0
    val times = HashMap<Int, Int>()
    for (i in 0..<y) {
        val t = readln().split(' ').map { it.toInt() }
        for (j in t.indices) {
            val n = t[j]
            floor[i * x + j] = n
            if (min > n) min = n
            if (max < n) max = n
        }
    }

    var sum = 0
    for (i1 in floor) sum += i1
    sum += inv

    for (i in min..max) {
        if (i * x * y > sum) break
        val time = action(floor, x, y, i, inv) ?: continue
        times[time] = maxOf(times[time] ?: 0, i)
    }

    val (time, height) = times.minBy { it.key }
    print("$time $height")
}

fun action(floor: IntArray, x: Int, y: Int, targetY: Int, blocks: Int): Int? {
    var times = 0
    var neededBlock = 0

    for (i in 0..<y) {
        for (j in 0..<x) {
            val target = floor[i * x + j]
            if (target > targetY) {
                val diff = target - targetY
                times += 2 * diff
                neededBlock -= diff
            } else if (target < targetY) {
                val diff = targetY - target
                times += diff
                neededBlock += diff
            }
        }
    }
    if (blocks - neededBlock < 0) return null

    return times
}
