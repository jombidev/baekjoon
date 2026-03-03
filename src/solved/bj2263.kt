fun main() {
    val n = readln().toInt()

    val `in` = readln().split(' ').map { it.toInt() }
    val post = readln().split(' ').map { it.toInt() }

    fun scan(inL: Int, postL: Int, len: Int) {
        if (len == 0) {
            // leaf node
            println(`in`[inL])
            return
        }

        if (len < 0) return
        val mid = `in`.indexOf(post[postL + len])
        val lenLeft = mid - inL - 1
        val lenRight = len - 1 - lenLeft - 1

        println(post[postL + len]) // parent
        scan(inL, postL, lenLeft) // left
        scan(mid + 1, postL + lenLeft + 1, lenRight) // right
        // end
    }

    scan(0, 0, n - 1)
    /*
    entry, leaf, end에 println 추가시 트리 구조 확인 가능
    */
}
