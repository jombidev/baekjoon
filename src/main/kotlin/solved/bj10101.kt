package solved

fun main() {
    val n = List(3) { readln().toInt() }
    print(
        if (n.all { it == 60 }) "Equilateral"
        else if (n.sum() == 180) {
            if (n.toSet().size != n.size) "Isosceles"
            else "Scalene"
        } else "Error"
    )
}