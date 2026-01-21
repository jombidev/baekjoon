import java.math.BigInteger
import java.util.StringTokenizer
import kotlin.collections.contains

val CHOSEONG_MAP = arrayOf('ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ')
val JONGSEONG_MAP = arrayOf(' ', 'ㄱ', 'ㄲ', 'ㄳ', 'ㄴ', 'ㄵ', 'ㄶ', 'ㄷ', 'ㄹ', 'ㄺ', 'ㄻ', 'ㄼ', 'ㄽ', 'ㄾ', 'ㄿ', 'ㅀ', 'ㅁ', 'ㅂ', 'ㅄ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ')

const val HANGUL_START = '가'.code
const val CHOSEONG_INDEX = '깋' - '가' + 1

val TEN = 10.toBigInteger()

data class Hangul(val choseong: Char, val jungseong: Char, val jongseong: Char? = null)

fun Char.split(): Hangul? {
    if (this !in '가'..'힣')
        return null

    val choseong = CHOSEONG_MAP[(code - HANGUL_START) / CHOSEONG_INDEX]
    val jungseong = 'ㅏ' + (code - HANGUL_START) % CHOSEONG_INDEX / JONGSEONG_MAP.size
    val jongseong = if (JONGSEONG_MAP[(code - HANGUL_START) % CHOSEONG_INDEX % JONGSEONG_MAP.size] == ' ') null else JONGSEONG_MAP[(code - HANGUL_START) % CHOSEONG_INDEX % JONGSEONG_MAP.size]

    return Hangul(choseong, jungseong, jongseong)
}

fun main() = repeat(readln().toInt()) {
    val g1 = " 일이삼사오육칠팔구".map { it.split() }
    val g2 = " 십백천".map { it.split() }
    val g3 = " 만억조경해자양구간정재극".map { it.split() }

    val st = StringTokenizer(readln(), " ")

    var n = st.nextToken().toBigInteger()
    val ignored = readln().split(' ').map { it[0] }.toSet()

    var available = BigInteger.ZERO

    val arr = Array(52) { BigInteger.ZERO }
    val g1Allowed = BooleanArray(10)
    val g3Allowed = BooleanArray(13)
    g1Allowed[0] = true
    g3Allowed[0] = true

    for (i in 0..<52) {
        if (i > 0) arr[i - 1] = available
        var res = BigInteger.ONE

        val g3n = g3[i / 4]
        if (g3n != null && (g3n.choseong in ignored || g3n.jungseong in ignored || g3n.jongseong?.let { it in ignored } ?: false))
            continue
        g3Allowed[i / 4] = true

        val g2n = g2[i % 4]
        if (g2n != null && (g2n.choseong in ignored || g2n.jungseong in ignored || g2n.jongseong?.let { it in ignored } ?: false))
            continue

        for (j in 1..9) {
            val g1n = g1[j]!!
            if (g1n.choseong in ignored || g1n.jungseong in ignored || g1n.jongseong?.let { it in ignored } ?: false)
                continue

            g1Allowed[j] = true
            res++
        }

        if (available == BigInteger.ZERO) available = res else available *= res
    }
    arr[51] = available

    val max = TEN.pow(52) - BigInteger.ONE

    if (arr.indexOfFirst { it > n } == -1) return@repeat println(-1)

    var targetNumber = BigInteger.ZERO

    for (i in 51 downTo 1) {
        var modCount = 0
        while (n >= arr[i - 1]) {
            val tp = TEN.pow(i)

            do {
                targetNumber += tp
                modCount++
            } while (!g1Allowed[(targetNumber / tp % TEN).toInt()])
            if (max < targetNumber) return@repeat println(-1)

            n -= arr[i - 1]
        }

        if (modCount != 0 && !g3Allowed[i / 4]) return@repeat println(-1)
    }

    var modCount = 0
    while (n-- > BigInteger.ZERO)
        do {
            targetNumber++
            modCount++

            if (modCount > 9999) return@repeat println(-1) // g3 violate
        } while (!g1Allowed[(targetNumber % TEN).toInt()])
    if (max < targetNumber) return@repeat println(-1)

    println(targetNumber)
}
