import java.util.StringTokenizer

fun main() = System.`in`.bufferedReader().use {
    fun r() = it.readLine()

    val d = StringTokenizer(r(), " ")
    val d0 = d.nextToken().toInt()
    val d1 = d.nextToken().toInt()
    val d2 = d.nextToken().toInt()
    val d3 = d.nextToken().toInt()
    val d4 = d.nextToken().toInt()
    val d5 = d.nextToken().toInt()
    val d6 = d.nextToken().toInt()
    val d7 = d.nextToken().toInt()
    val d8 = d.nextToken().toInt()
    val d9 = d.nextToken().toInt()
    val d10 = d.nextToken().toInt()

    val tomatoes = ArrayDeque<IntArray>()
    var zc = 0

    val b = Array(d10) { n10 ->
        Array(d9) { n9 ->
            Array(d8) { n8 ->
                Array(d7) { n7 ->
                    Array(d6) { n6 ->
                        Array(d5) { n5 ->
                            Array(d4) { n4 ->
                                Array(d3) { n3 ->
                                    Array(d2) { n2 ->
                                        Array(d1) { n1 ->
                                            val t = IntArray(d0)
                                            val r = StringTokenizer(r(), " ")
                                            for (n0 in 0..<d0) {
                                                val i = r.nextToken().toInt()
                                                t[n0] = i
                                                if (i == 1) {
                                                    tomatoes.add(intArrayOf(n0, n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, 0))
                                                } else if (i == 0) zc++
                                            }
                                            t
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    if (zc == 0) return print(0)

    val v0 = intArrayOf(1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    val v1 = intArrayOf(0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    val v2 = intArrayOf(0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    val v3 = intArrayOf(0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    val v4 = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    val v5 = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    val v6 = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0)
    val v7 = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0)
    val v8 = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0)
    val v9 = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0)
    val v10 = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1)
    var ssDay = 0

    while (tomatoes.isNotEmpty()) {
        val n = tomatoes.removeFirst()

        ssDay = maxOf(n[11], ssDay)

        for (i in 0..<22) {
            val o0 = n[0] + v0[i]
            val o1 = n[1] + v1[i]
            val o2 = n[2] + v2[i]
            val o3 = n[3] + v3[i]
            val o4 = n[4] + v4[i]
            val o5 = n[5] + v5[i]
            val o6 = n[6] + v6[i]
            val o7 = n[7] + v7[i]
            val o8 = n[8] + v8[i]
            val o9 = n[9] + v9[i]
            val o10 = n[10] + v10[i]

            if (o0 !in 0..<d0 || o1 !in 0..<d1 || o2 !in 0..<d2 || o3 !in 0..<d3 || o4 !in 0..<d4 || o5 !in 0..<d5 || o6 !in 0..<d6 || o7 !in 0..<d7 || o8 !in 0..<d8 || o9 !in 0..<d9 || o10 !in 0..<d10 || b[o10][o9][o8][o7][o6][o5][o4][o3][o2][o1][o0] != 0) continue
            b[o10][o9][o8][o7][o6][o5][o4][o3][o2][o1][o0] = 1
            zc--

            if (zc == 0)
                return print(n[11] + 1)

            tomatoes.add(intArrayOf(o0, o1, o2, o3, o4, o5, o6, o7, o8, o9, o10, n[11] + 1))
        }
    }
    print(if (zc != 0) -1 else ssDay)
}
