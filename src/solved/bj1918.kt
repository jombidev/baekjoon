import java.util.LinkedList

fun main() {
    val stack = LinkedList<Char>()
    val sb = StringBuilder()

    for (ch in readln()) {
        when (ch) {
            in 'A'..'Z' -> {
                sb.append(ch)
                if (stack.isNotEmpty()) {
                    if (stack.peekLast() in "*/")
                        sb.append(stack.removeLast())
                }
            }
            '(' -> stack.add('(')
            ')' -> {
                while (stack.peekLast() != '(')
                    sb.append(stack.removeLast())
                stack.removeLast()
            }
            in "+-" -> {
                while (stack.peekLast() != null && stack.peekLast() != '(')
                    sb.append(stack.removeLast())
                stack.add(ch)
            }
            in "*/" -> {
                if (stack.peekLast() != null && stack.peekLast() in "/*") {
                    sb.append(stack.removeLast())
                }
                stack.add(ch)
            }
        }
    }

    while (stack.isNotEmpty())
        sb.append(stack.removeLast())

    println(sb)
}
