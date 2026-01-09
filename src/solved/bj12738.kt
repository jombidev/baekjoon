fun main() {
    class Node(val v: Int, val parent: Node? = null)

    val n = readln().toInt()
    val a = readln().split(' ').map { it.toInt() }.toIntArray()

    val lisTree = ArrayList<Node>(n + 1)
    lisTree.add(Node(Int.MIN_VALUE))

    for (i in a) {
        val temp = lisTree.binarySearch { it.v.compareTo(i) }
        val index = if (temp >= 0) temp else -(temp + 1)
        if (index == lisTree.size)
            lisTree.add(Node(i, lisTree.last()))
        else {
            lisTree[index] = Node(i, lisTree[index - 1])
        }
    }

    print(lisTree.size - 1)
}
