fun main() {
    val correct = listOf(1, 1, 2, 2, 2, 8)
    print(readln().split(' ').mapIndexed { i, j -> correct[i] - (j[0] - '0') }.joinToString(" "))
}
