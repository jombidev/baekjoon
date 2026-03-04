fun main() {
    val s = readln()

    fun rec(prefix: String = ""): String? {
        if (!s.contains(prefix))
            return prefix

        for (i in 'a'..'z') {
            val res = rec(prefix + i)
            if (res != null)
                return res
        }

        return null
    }


    for (i in 'a'..'z') {
        val res = rec("$i")
        if (res != null)
            return print(res)
    }
}
