fun main() {
    repeat(readln().toInt()) {
        val (init, targ) = readln().split(' ').map { it.toInt() }

        val v = BooleanArray(10000)

        val ll = java.util.LinkedList<Pair<Int, String>>()
        ll.add(init to "")

        while (ll.isNotEmpty()) {
            val (cur, c) = ll.removeFirst()

            if (cur == targ) {
                println(c)
                break
            }

            fun check(i: Int, a: Char) {
                if (v[i])
                    return
                v[i] = true

                ll.add(i to c + a)
            }

            check(d(cur), 'D')
            check(s(cur), 'S')
            check(l(cur), 'L')
            check(r(cur), 'R')
        }
    }
}

fun d(i: Int) = i * 2 % 10000
fun s(i: Int) = if (i - 1 < 0) 9999 else i - 1
fun l(i: Int): Int = (i - i / 1000 * 1000) * 10 + i / 1000 % 10
fun r(i: Int): Int = i / 10 + i % 10 * 1000
