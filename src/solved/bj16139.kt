fun main() {
    val s = readln()

    val dp = Array(26) { IntArray(s.length + 1) }
    for (c in 'a'..'z') {
        for (i in s.indices) {
            dp[c - 'a'][i + 1] = dp[c - 'a'][i] + if (s[i] == c) 1 else 0
        }
    }

    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val (c, s, e) = readln().split(' ').map { if (it[0] in 'a'..'z') it[0] - 'a' else it.toInt() }
        sb.append(dp[c][e + 1] - dp[c][s]).append('\n')
    }

    print(sb)
}
