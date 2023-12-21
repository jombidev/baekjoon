package fail

fun main()=System.`in`.bufferedReader().use {
    val read = java.util.StringTokenizer(it.readText(), " \n")
    val W = read.nextToken().toInt()
    val V = read.nextToken().toInt()
    val U = read.nextToken().toInt()
    val T = read.nextToken().toInt()
    val S = read.nextToken().toInt()
    val R = read.nextToken().toInt()
    val Q = read.nextToken().toInt()
    val P = read.nextToken().toInt()
    val O = read.nextToken().toInt()
    val N = read.nextToken().toInt()
    val M = read.nextToken().toInt()
    val b = Array(M) { Array(N) { Array(O) { Array(P) { Array(Q) { Array(R) { Array(S) { Array(T) { Array(U) { Array(V) { Array(W) { 0 } } } } } } } } } } }
    val bfsQ = ArrayList<Array<Int>>()
    var works = 0
    var max = M * N * O * P * Q * R * S * T * U * V * W
    for (m in 0..<M) for (n in 0..<N) for (o in 0..<O) for (p in 0..<P) for (q in 0..<Q) for (r in 0..<R) for (s in 0..<S) for (t in 0..<T) for (u in 0..<U) for (v in 0..<V) for (w in 0..<W) {
        val value = read.nextToken().toInt()
        b.get(m).get(n).get(o).get(p).get(q).get(r).get(s).get(t).get(u).get(v).set(w, value)
        if (value == 1) bfsQ.add(arrayOf(m, n, o, p, q, r, s, t, u ,v, w, 0)).let { works++ }
        if (value == -1) max--
    }
    val offsetM = arrayOf(1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    val offsetN = arrayOf(0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    val offsetO = arrayOf(0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    val offsetP = arrayOf(0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    val offsetQ = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    val offsetR = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    val offsetS = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0)
    val offsetT = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0)
    val offsetU = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0)
    val offsetV = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0)
    val offsetW = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1)

    var workmm = 0

    while (bfsQ.isNotEmpty()) {1
        val c = bfsQ.removeFirst()
        var found = false
        for (i in 0 ..< 22) {
            val mm = c[0] + offsetM[i]
            val nn = c[1] + offsetN[i]
            val oo = c[2] + offsetO[i]
            val pp = c[3] + offsetP[i]
            val qq = c[4] + offsetQ[i]
            val rr = c[5] + offsetR[i]
            val ss = c[6] + offsetS[i]
            val tt = c[7] + offsetT[i]
            val uu = c[8] + offsetU[i]
            val vv = c[9] + offsetV[i]
            val ww = c[10] + offsetW[i]

            if (mm < 0 || nn < 0 || oo < 0 || pp < 0 || qq < 0 || rr < 0 || ss < 0 || tt < 0 || uu < 0 || vv < 0 || ww < 0 ||
                mm >= M || nn >= N || oo >= O || pp >= P || qq >= Q || rr >= R || ss >= S || tt >= T || uu >= U || vv >= V || ww >= W) continue

            if (b[mm][nn][oo][pp][qq][rr][ss][tt][uu][vv][ww] == 0) {
                b[mm][nn][oo][pp][qq][rr][ss][tt][uu][vv][ww] = 1
                bfsQ.add(arrayOf(mm, nn, oo, pp, qq, rr, ss, tt, uu, vv, ww, c[11] + 1))
                works++
                found = true
            }
        }

        if (found) workmm = if (workmm >= c[11] + 1) workmm else c[11] + 1
    }
    print(if (works == max) workmm else -1)
}
