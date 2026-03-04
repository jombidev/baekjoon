fun main() {
    readln()
    val bsa = IntArray(3)
    for (ch in readln()) {
        bsa["BSA".indexOf(ch)]++
    }

    print(
        if (bsa.distinct().size == 1) {
            "SCU"
        } else {
            val max = bsa.max()
            val sb = StringBuilder()

            if (bsa[0] == max) {
                sb.append('B')
            }
            if (bsa[1] == max)
                sb.append('S')
            if (bsa[2] == max)
                sb.append('A')
            sb.toString()
        }
    )
}
