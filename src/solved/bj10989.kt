fun main() = System.`in`.bufferedReader().use {
    val a = HashMap<Short, Int>()

    repeat(it.readLine().toInt()) {_->
        val target = it.readLine().toShort()
        if (!a.contains(target)) a[target] = 0
        a[target] = a[target]!! + 1
    }

    a.toSortedMap().forEach {
        print("${it.key}\n".repeat(it.value))
    }
}
