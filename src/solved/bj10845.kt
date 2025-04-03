fun main() {
    val stack = ArrayDeque<String>(10000)
    repeat(readln().toInt()) {
        val r = readln().split(' ')
        when (r[0]) {
            "push" -> stack.add(r[1])
            "pop" -> println(stack.removeFirstOrNull() ?: -1)
            "front" -> println(stack.firstOrNull() ?: -1)
            "back" -> println(stack.lastOrNull() ?: -1)
            "size" -> println(stack.size)
            "empty" -> println(if (stack.isEmpty()) 1 else 0)
        }
    }
}
