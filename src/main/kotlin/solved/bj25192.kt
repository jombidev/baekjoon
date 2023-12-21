package solved

fun main() {
    var visitSet = hashSetOf<String>()
    var isEnter = false
    var hellos = 0
    for (i in 0 ..< readln().toInt()) {
        val n = readln()
        if (n == "ENTER") {
            isEnter = true
            visitSet = hashSetOf()
            continue
        }
        if (isEnter) {
            if (!visitSet.contains(n))
                visitSet.add(n).let { hellos++ }
        }
    }
    print(hellos)
}