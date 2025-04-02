fun main() {
    fibos[0] = FiboInfo(0, 1, 0)
    fibos[1] = FiboInfo(1, 0, 1)
    for (i in List(readln().toInt()) { readln().toInt() }) {
        val n = fibonacci(i)
        println("${n.z} ${n.o}")
    }
}

private val fibos = arrayOfNulls<FiboInfo>(41)
class FiboInfo(val v: Int, val z: Int, val o: Int)

fun fibonacci(n: Int): FiboInfo {
    if (fibos[n] == null) {
        val o = fibonacci(n - 1)
        val t = fibonacci(n - 2)
        fibos[n] = FiboInfo(o.v + t.v, o.z + t.z, o.o + t.o)
    }
    return fibos[n]!!
}
