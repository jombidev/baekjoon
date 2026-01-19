fun main() = repeat(readln().toInt()) {
    readln().let {
        if (it.indexOf("Simon says") >= 0)
            println(it.substring(10))
    }
}
