package fail

fun main()=System.`in`.bufferedReader().use {
    val bw = System.out.bufferedWriter()
    it.readLine()
    val b = BinaryTree()
    for (i in it.readLine().split(' ').map { it.toInt() }) b.add(i)
    it.readLine()
    for (c in it.readLine().split(' ').map { it.toInt() })bw.write("${if (b.exists(c)) 1 else 0} ")
    bw.flush()
    bw.close()
}
class Node(val value: Int, var left: Node? = null, var right: Node? = null) {
    fun add(node: Node) {
        if (node == this) return
        if (value > node.value) {
            if (left == null) left = node
            else left?.add(node)
        } else if (value < node.value) {
            if (right == null) right = node
            else right?.add(node)
        }
    }

    fun exists(i: Int): Boolean {
        if (value == i) return true
        if (value > i) return left?.exists(i) ?: false
        return right?.exists(i) ?: false
    }
}
class BinaryTree {
    private var root: Node? = null
    fun add(i: Int) {
        val n = Node(i)
        if (root == null) root = n
        else root?.add(n)
    }
    fun exists(i: Int): Boolean {
        return root?.exists(i) ?: false
    }
}