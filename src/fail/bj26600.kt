@file:OptIn(ExperimentalUnsignedTypes::class)

package fail

fun main() = System.`in`.bufferedReader().use {
    val len = it.readLine().toInt()
    val t = Array(len) { 0UL }
    for ((i, u) in it.readLine().split(' ').map { it.toULong() }.withIndex()) {
        t[i] = u
    }
    radixSort(t, len)

    repeat(it.readLine().toInt()) {_->
        val (op, mod, n) = it.readLine().split(' ')
        val num = n.toULong()
        if (op == "map") {
            for (i in t.indices) {
                when (mod) {
                    "+" -> t[i] += num
                    "*" -> t[i] *= num
                    "%" -> t[i] %= num
                }
            }
            radixSort(t, len)
        } else if (op == "filter") {
            var c = 0
            var bkt = false
            for (i in t.indices)
                when (mod) {
                    ">=" -> {
                        if (t[len - i - 1] >= num) c++
                        else break
                    }
                    "<=" -> {
                        if (t[i] > num) {
                            println(i)
                            bkt = true
                            break
                        }
                        c++
                    }
                    "==" -> {
                        if (t[i] > num) {
                            println(c)
                            bkt = true
                            break
                        }
                        if (t[i] == num) c++
                    }
                }
            if (!bkt) println(c)
        }
    }
}

fun radixSort(arr: Array<ULong>, len: Int) {
    var exp = 1UL
    while (9_223_372_036_854_775_807u / exp > 0u) {
        val output = ULongArray(len)
        val count = ULongArray(10) { 0UL }
        for (i in 0..< len) count[(arr[i] / exp % 10u).toInt()]++
        for (i in 1..9) count[i] += count[i - 1]
        for (i in len - 1 downTo 0) {
            output[count[(arr[i] / exp % 10u).toInt()].toInt() - 1] = arr[i]
            count[(arr[i] / exp % 10u).toInt()]--
        }
        for (i in 0..< len) arr[i] = output[i]
        exp *= 10u
    }
}