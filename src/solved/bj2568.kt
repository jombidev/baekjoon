fun main() {
    class Node(val v: List<Int>, val parent: Node? = null)

    val n = readln().toInt()
    val a = Array(n) { readln().split(' ').map { it.toInt() } }
    a.sortBy { it[0] }

    val lisTree = ArrayList<Node>(n + 1)
    lisTree.add(Node(listOf(0, Int.MIN_VALUE)))

    for (i in a) {
        val temp = lisTree.binarySearch { it.v[1].compareTo(i[1]) }
        val index = if (temp >= 0) temp else -(temp + 1)
        if (index == lisTree.size)
            lisTree.add(Node(i, lisTree.last()))
        else {
            lisTree[index] = Node(i, lisTree[index - 1])
        }
    }

    val set = a.toMutableSet()

    var lisNode: Node? = lisTree.last()
    while (lisNode != null && lisNode.v[1] != Int.MIN_VALUE) {
        set.remove(lisNode.v)
        lisNode = lisNode.parent
    }

    println(set.size)
    print(set.map { it[0] }.sorted().joinToString(" "))
}
