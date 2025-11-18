var touched = 0

fun main() {
    val (n, k) = readln().split(' ').map { it.toInt() }
    val a = readln().split(' ').map { it.toInt() }.toIntArray()
    val tmp = IntArray(n)

    k.sort(a, tmp) {
        print(it)
        System.exit(0)
    }
    print(-1)
}

fun Int.sort(a: IntArray, tmp: IntArray, l: Int = 0, r: Int = a.lastIndex, cb: (Int) -> Unit) {
    if (l < r) {
        val c = (l + r) / 2
        sort(a, tmp, l, c, cb)
        sort(a, tmp, c + 1, r, cb)
        merge(a, tmp, l, c, r, cb)
    }
}

fun Int.merge(a: IntArray, tmp: IntArray, l: Int, c: Int, r: Int, cb: (Int) -> Unit) {
    var i = l
    var j = c + 1
    var t = 0

    while (i <= c && j <= r) {
        if (a[i] <= a[j]) tmp[t++] = a[i++]
        else tmp[t++] = a[j++]
    }

    while (i <= c)
        tmp[t++] = a[i++]
    while (j <= r)
        tmp[t++] = a[j++]

    i = l
    t = 0
    while (i <= r) {
        if (++touched == this) {
            cb(tmp[t])
        }
        a[i++] = tmp[t++]
    }
}
