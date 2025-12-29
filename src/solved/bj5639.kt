fun main() {
    class Binary(val v: Int, var l: Binary? = null, var r: Binary? = null)

    var root: Binary? = null

    for (n in String(System.`in`.readBytes()).split("\n").map { it.trim() }.filter { it.isNotBlank() }.map { it.toInt() }) {
        if (root == null) {
            root = Binary(n)
        } else {
            fun scanSet(node: Binary) {
                if (node.v > n) {
                    if (node.l == null) {
                        node.l = Binary(n)
                    } else {
                        scanSet(node.l!!)
                    }
                } else {
                    if (node.r == null) {
                        node.r = Binary(n)
                    } else {
                        scanSet(node.r!!)
                    }
                }
            }
            scanSet(root)
        }
    }

    fun postfix(node: Binary) {
        if (node.l != null) {
            postfix(node.l!!)
        }
        if (node.r != null) {
            postfix(node.r!!)
        }
        println(node.v)
    }

    postfix(root!!)
}
