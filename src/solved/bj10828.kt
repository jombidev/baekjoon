fun main() {
    val stack = ArrayDeque<String>(10000)
    repeat(readln().toInt()) {
        val r = readln().split(' ')
        when (r[0]) {
            "push" -> stack.add(r[1])
            "pop" -> println(stack.removeLastOrNull() ?: -1)
            "top" -> println(stack.lastOrNull() ?: -1)
            "size" -> println(stack.size)
            "empty" -> println(if (stack.isEmpty()) 1 else 0)
        }
    }
}
