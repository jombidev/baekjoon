fun main() = print(
    when (readln().toInt()) {
        1, 2 -> 1
        3, 4, 5 -> 2
        else -> 3
    }
)
