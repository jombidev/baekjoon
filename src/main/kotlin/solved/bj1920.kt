fun main() {
    val br = System.`in`.bufferedReader()
    val hashMap = hashMapOf<Int, Boolean>()
    br.readLine()
    for (s in br.readLine().split(' ')) {
        hashMap[s.toInt()] = true
    }
    br.readLine()
    for (c1 in br.readLine().split(' ')) {
        println(if (hashMap[c1.toInt()] == true) 1 else 0)
    }
}
