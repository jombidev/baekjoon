fun main() {
    val (rh, rv, sh, sv) = readln().split(' ').map { it.toInt() }
    val m = Array(readln().toInt()) { readln().split(' ').map { it.toInt() } }

    fun cd(a: Int, b: Int) = Math.ceil(a.toDouble() / b).toInt()

    fun act(rhi: Int, rvi: Int, shi: Int, svi: Int, pi: Int): Int {
        var shb = cd(sh, shi)
        var svb = cd(sv, svi)

        while (shb * rhi < rh) shb++
        while (svb * rvi < rv) svb++

        return pi * shb * svb
    }

    print(m.minOf { (rhi, rvi, shi, svi, pi) -> minOf(act(rhi, rvi, shi, svi, pi), act(rvi, rhi, svi, shi, pi)) })
}
