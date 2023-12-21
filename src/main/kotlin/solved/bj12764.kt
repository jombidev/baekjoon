package solved//import java.util.PriorityQueue
//
//fun main() {
//    val r = System.`in`.bufferedReader()
//    val N = r.readLine().toInt()
//    val us = Array(N) { r.readLine().split(' ').map { it.toInt() } }
//    us.sortBy { it[0] }
//    val pcs = Array(N) { 0 }
//    val using = PriorityQueue<Pair<Int, Int>> { i, j -> i.second.compareTo(j.second) }
//    while (us.isNotEmpty()) {
//        val (start, end) = us.remove()
//        using.remove()
//        val i = using.indexOf(-1)
//        pcs[i]++
//        using[i] = end
//    }
//    println(pcs.indexOf(0))
//    val w = System.out.bufferedWriter()
//    for (pc in pcs) {
//        if (pc < 1) break
//        w.write("$pc ")
//    }
//    w.flush()
//    r.close()
//    w.close()
//}