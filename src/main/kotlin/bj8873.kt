fun main() {
    val (height, width) = readln().split(' ').map { it.toInt() }
    val r = Array(height) { Array(width) { 0 } }
    val g = Array(height) { Array(width) { 0 } }
    val b = Array(height) { Array(width) { 0 } }
    System.`in`.bufferedReader().use {
        var j = 0
        for (i in 0 until height) {
            for (s in it.readLine().split(' ')) r[i][j++] = s.toInt()
        }
    }
}