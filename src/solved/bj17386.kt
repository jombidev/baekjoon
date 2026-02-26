/*
fun main(){val(a,b,c,d)=readln().split(' ').map{it.toDouble()}
val(e,f,g,h)=readln().split(' ').map{it.toDouble()}
print(if(java.awt.geom.Line2D.linesIntersect(a,b,c,d,e,f,g,h))1 else 0)}
*/

fun ccw(x1: Long, y1: Long, x2: Long, y2: Long, x3: Long, y3: Long) =
    ((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1)).compareTo(0)

fun main() {
    val (x1, y1, x2, y2) = readln().split(' ').map { it.toLong() }
    val (x3, y3, x4, y4) = readln().split(' ').map { it.toLong() }

    print(
        if (minOf(x1, x2) > maxOf(x3, x4) || minOf(y1, y2) > maxOf(y3, y4) || minOf(x3, x4) > maxOf(x1, x2) || minOf(y3, y4) > maxOf(y1, y2))
            0
        else {
            val line1 = (ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4)) <= 0
            val line2 = (ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2)) <= 0

            if (line1 && line2) 1 else 0
        }
    )
}
