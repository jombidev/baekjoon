import java.math.BigInteger
import java.nio.ByteBuffer
import java.util.Base64

fun main() {
val sb = StringBuilder()
val n = readln().toInt()
when (n) {
0 -> sb.append("ONTAK 2010\n")
1 -> {
var sn = 2932
var seq = 0
val m = "Godzilla terrorizes Bajtoly lower again. Every day a monster comes out of the ocean, slow movement of marching through the city to some of the skyscrapers and eats it with people who are in it. Eating one skyscraper takes the whole day, at dusk, it returns to its hiding place hidden in the depths. To make matters worse, going through the city, Godzilla wags its tail and destroys towers, near the passes. The prospect of becoming a meal for an underwater monster, to discourage some residents spent in uncomfort- tion in the city. During the night of each tower is derived as a resident and flees to the countryside. In Bajtogrodzie skyscrapers were built only at street crossings. At each intersection there is exactly one building. Junctions are connected by two-way streets. In addition, a the junction is just above the ocean, this is where Godzilla begins its destructive journey through the city. During the investigation, the monster moves only in the streets. Godzilla noted that he must hurry up with the consumption of residents and carefully choose the skyscrapers devouring and streets, which reaches them. Of course, choosing never previously consumed or destroyed- wanego skyscraper. What is the maximum number of people who can eat before the city completely desolate? Entrance The first line of standard input contains two integers him (1 n 100 000, 0 500 000 m) respectively denoting the number of intersections in the city and the number of connecting streets. Crossroads numbers are numbered from 1 to n, junction 1 is located on the shores of the ocean. Next row contains a sequence of integers n s (0 s 100 000) to describe population skyscrapers at various intersections. In each of the next m rows are the two integers ai and bi (1 ai, bi n, ai = bi), which means that there is a road junction connecting ai and bi. The crossing number One can reach any other intersection in the city. Exit Write to stdout the number of people who eat Godzilla for the optimum choice of meals and roads through the city every day. Example For input: the result is correct: 5 5 11 1 3 2 4 7 1 2 1 3 2 3 2 4 3 5"
for (i in 0..<m.length) {
sb.append("${m[i]}".repeat(sn))
seq += if (seq == 0) 1 else 2
if (sn - seq < 0) {
sn += 2932 - seq
} else if (sn - seq == 0){
seq = 0
sn = 2932
}else sn -= seq
}
sb.append('\n')
}
2 -> {
val dp = ULongArray(10001)
dp[1] = 1UL
sb.append("1, ")
for (i in 2..10000) {
dp[i] = (dp[i - 1] + dp[i - 2]) % 9099099909999099999UL
sb.append(dp[i]).append(", ")
}
sb.append("0.\n")
}
3 -> {
val pat = arrayOf("####", "#.#.", "##..", "#...")
val n = ArrayList<String>(1024)
for (i in 0..<4) {
val sb = StringBuilder()
repeat(255) { sb.append(pat[i]) }
sb.append(pat[i].trimEnd('.'))
n.add(sb.toString())
}

var iter = 4

fun tri(w: Int) {
if (w == 1024) return

val ws = ".".repeat(iter)

for (i in 0..<w) {
val s = n[i].take(iter)
val sb = StringBuilder()

repeat(512 / iter - 1) {
sb.append(s)
sb.append(ws)
}
sb.append(s.trimEnd('.'))
n.add(sb.toString())
}
iter *= 2

tri(n.size)
}

tri(n.size)
val t = arrayOf(
".####..##..##.######..##...##..##.....####...####..###..####.",
"##..##.###.##...##...####..##.##.....##..##.##..##..##.##..##",
"##..##.##.###...##..##..##.####.........##..##..##..##.##..##",
"##..##.##..##...##..######.##.##......##....##..##..##.##..##",
".####..##..##...##..##..##.##..##....######..####...##..####."
)

for (i in 506..510) {
val sb = StringBuilder(n[i].substring(0, 449))
sb.append(t[i - 506])
sb.append(n[i].substring(510))
n[i] = sb.toString()
}

for (s in n) sb.append(s).append('\n')
}
4 -> {
val p = CharArray(405000) { if (it % 81 == 80) '\n' else '0' }
p[404998] = '1'
for (i in 2..400000) {
if (p[i - 2 + (i - 2) / 80] == '0') {
for (px in i..400000 step i) {
p[px - 2 + (px - 2) / 80] = '1'
}
p[i - 2 + (i - 2) / 80] = '0'
}
}

for ((i, c) in "9099099909999099999".withIndex()) {
p[3333 * 81 + 8 + i] = c
}

sb.append(p)
}
5 -> {
val y = arrayOf(
"pierwsz",
"drugi",
"trzeci",
"czwart",
"piat",
"szost",
"siodm",
"osm",
"dziewiat",
"dziesiat",
"jedenast",
"dwunast",
"trzynast",
"czternast",
"pietnast",
"szesnast",
"siedemnast",
"osiemnast",
"dziewietnast",
"dwudziest"
)
val m = arrayOf(
"stycznia",
"lutego",
"marca",
"kwietnia",
"maja",
"czerwca",
"lipca",
"sierpnia",
"wrzesnia",
"pazdziernika",
"listopada",
"grudnia"
)
val arr = arrayOf(
"",
"pierwszy",
"drugi",
"trzeci",
"czwarty",
"piaty",
"szosty",
"siodmy",
"osmy",
"dziewiaty",
"dziesiaty",
"jedenasty",
"dwunasty",
"trzynasty",
"czternasty",
"pietnasty",
"szesnasty",
"siedemnasty",
"osiemnasty",
"dziewietnasty"
)
val mod = arrayOf(
"", // 0
"", // 10
"dwudziesty",
"trzydziesty",
"czterdziesty",
"piecdziesiaty",
"szescdziesiaty",
"siedemdziesiaty",
"osiemdziesiaty",
"dziewiecdziesiaty"
)
val hm = arrayOf(
"",
"sto",
"dwiescie",
"trzysta",
)
val n = arrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
fun genYear(i: Int): String {
return if (i == 0) "dwutysiecznego"
else "dwa tysiace ${y[i - 1]}ego"
}
fun genMonth(i: Int) = m[i]
fun genNumber(i: Int): String {
return when (i) {
100 -> "setny"
200 -> "dwusetny"
300 -> "trzysetny"
else -> "${hm[i / 100]} ${if (i % 100 < 20) arr[i % 100] else "${mod[i / 10 % 10]} ${arr[i % 10]}"}".replace(
"  ",
" "
).trim()
}
}

for (i in 0..20) {
val y = genYear(i)
var c = 1

for (j in n.indices) {
val m = genMonth(j)

for (k in 1..if (j == 1 && i % 4 == 0) 29 else n[j]) {
val d = genNumber(k)

if (i == 7 && c == 91)
sb.append("Pierwszego kwietnia jest prima aprilis.\n")
else if (i == 13 && c == 152)
sb.append("Pierwszego czerwca jest dzien dziecka.\n")
else
sb.append("${d[0].uppercase()}${d.substring(1)} $m to ${genNumber(c)} dzien roku $y.\n")
c++
}
}
}
sb.append("Koniec.\n")
}
6 -> {
val f = ArrayList<Long>()
f.add(1)
f.add(2)
f.add(6)

fun factorial(n: Int): Long {
if (n == 0) return 1
while (f.size < n) {
f.add(f.last() * (f.size + 1))
}
return f[n - 1]
}

var n = 0L
var c = 0
var str = "a"

val ll = java.util.LinkedList<Char>()
var btc = 0L

fun bt(target: Long, i: Int = 1): String? {
if (i == str.length) {
return if (btc++ == target) {
ll.joinToString("")
} else {
null
}
}

for (n in str.indices) {
if (ll.contains(str[n]))
continue
val f = factorial(str.length - ll.size - 1)
if (btc + f < target) {
btc += f
continue
}

ll.add(str[n])
val l = bt(target, i + 1)
if (l != null)
return l
ll.removeLast()
}

return null
}

for (i in 1..20000L) {
val target = i * i * i * i

var w = false
while (n < target) {
n += factorial(++c)
w = true
}

if (w) {
str = ('a'..<'a' + c).joinToString("")
}

val permutationIndex = target - (n - factorial(c) + 1)
val first = factorial(c) / str.length
val fc = str[(permutationIndex / first).toInt()]

ll.clear()
ll.add(fc)
btc = 0


sb.append("T[$target]=\"${if (i == 10000L) 9099099909999099999 else bt(permutationIndex % first)}\"\n")
}
}
7 -> {
val TWO = BigInteger.valueOf(2)

val ns = ArrayList<BigInteger>(171)

ns.add(BigInteger.ONE)
ns.add(TWO)
var pw = TWO

while (ns.size <= 170) {
pw = pw.multiply(TWO)
ns.add(pw)
}

val nums = arrayOf(
arrayOf(
".####..",
"##..##.",
"##..##.",
"##..##.",
".####..",
),
arrayOf(
"###.",
".##.",
".##.",
".##.",
".##.",
),
arrayOf(
".####..",
"##..##.",
"...##..",
".##....",
"######.",
), arrayOf(), arrayOf(), arrayOf(), arrayOf(), arrayOf(), arrayOf(), arrayOf(
".####..",
"##..##.",
".#####.",
"....##.",
".####.."
)
)
val comma = arrayOf(
"......",
"......",
"......",
"##....",
".#....",
)

val sbs = Array(5) { StringBuilder() }
val dots = CharArray(1000) { '.' }

for (integer in ns) {
val n = integer.toString(3).reversed()
val calcWidth = n.sumOf { nums[it - '0'][0].length } + 6/*comma*/
if (sbs[0].length + calcWidth > 1000) {
for (builder in sbs) {
sb.append(builder).append(CharArray(1000 - builder.length) { '.' }).append('\n')
builder.clear()
}
sb.append(dots).append('\n')
}

for ((i, builder) in sbs.withIndex()) {
for (ch in n) {
builder.append(nums[ch - '0'][i])
}
builder.append(comma[i])
}
}


for ((i, builder) in sbs.withIndex()) {
builder.append(nums[0][i])
builder.append(comma[if (i > 3) 3 else i])
}

for (builder in sbs) {
sb.append(builder).append(CharArray(1000 - builder.length) { '.' }).append('\n')
builder.clear()
}
sb.append(dots).append('\n')

val n = arrayOf(2, 4, 0, 0)
val b = arrayOf(
"01020102001020021020001020010200120000120001200102010200120120012001200102012001020102012001020102010102010201200120012012001220100200012002010201020102010200",
"120012012001200120012001200120012001200120012012001201002000102001201200020020010020102001200001020102000120002010200102020000102001202002102001200202010201",
"0201020010020201020201020200120010001200201200102012001200120102012002100002010200010200012022020012020102020102020102010909909990999909999902010200120012",
"0012010201020102012001201201020120102012002001020012001200120012000120012001200210200120000120012001201200120102001001001001010100101000020102010200102001020001"
)
for (s in b.indices) {
sb.append(dots).append('\n')
for (i in 0..4) {
for (ch in b[s]) {
sb.append(nums[ch - '0'][i])
}
sb.append(CharArray(n[s]) { '.' }).append('\n')
}
}
}
8 -> {
val v = Array(1000) { CharArray(1000) { '.' } }
v[500][500] = '#'

val t =
"^tyC2G2geWUXUXmp2j@:5Z3^3|NL|L4QLt2yQy3I3CIC4GCGCc2gGg4W3UeU2eU2XU2mUm3pXp5@3:j@:8>:>:Z3^>^>^3N|5NL2|LN^NL2y3syL3NL3Q2s2C4y2tQ4yCGCcgGC2IsyIs2C2g3egWcC6G2gUeU5g3Gcg2U3mpX2mU2eW4U3pXp@4pmUmU2mUp3:4Z:@:p5j2:2>3^>Z2:2@:@:@:2Z>^2|2N3^2>:Z>:^>^|L4tL4|2^2N^NLNQLQty3QtLtL|L6ty3ICICs2y3Q4y3C4GCGC2iC2syI4CsCGCcg5c2GC5cCGCg3WUeUWUW3g3cg4WU3mUmX2UXU2WUeW2UeUeU2mXmp5@pX2UXU2mUm3p2j@:@:3@:@3jp5@j@:3Z>:Z4>:5@:@:6Z>^4|^N^3>2:Z2>3Z^2NL|L5|L3|3^|^|^N2LNL2QLtQt2yQ3LQL5|L4tLt2y3s4yI2y3Qt4yty2I2CIC3GC6ICs8IC2scCG4cgGgG4C2GC5cCG4g3W3Ue2W2eg5Gg5UeU6XU2XU4WUWUeW2UeUeU3XUX3pXp3mpXmX2UXU2mUmXUmpXp2j3@:j:j@:j3p5@p2@j2@:6>:>:Z:Z:>:2@:2@:2j:@:4>:>3Z^9>4:Z>2:Z^>^>^|3NLNL2|L2|L|2N2|^N^|^N|3NL6QLtQ2Lt2QLtL15QLt3y5syIy5tyQ4tyQy3s3IC2sC5sC2ICI2CsyI6CsIC5cCc2G3c5GCcCGC5GC3GCG4cg4We3gW2eg6Gcg6e2WU2eU13WUWUeWUe2WUeUeU5XUmX2m2pXmpXm5XUXU2mUXUXUmX3mp4j5@7jp8jpj5:j:6>:3Z:9j:@:@:@:3j:2>:2Z>5^>^2Z^2>^>4:Z2>:Z>2:Z^>2^4N|2NL|NL|NL|N5|^N^|^|^|6L|L6QL2tQLQLQL2QL7NL11tLt3yQyQy9tyQ2t7yQyQy3Is2ICsIC2sCIC2sCsICs6yI2s4ICsCsC5cCGCcGCc2G2CcCcCcC2GC8GC3cGCc3gGg6WgWgeg5cgGcgcgcg5W4UWUWU4eU4WU2WUWUeWUe3W2UeWUeUeU6mUmXUm11X2UXUXU2mU2mUXUXUXUm3pXp5j2p@2j2p@jpjp12jp@3:j@:3j:7>:3@:4@:@:@:@:@:@:@:9Z>:Z2>Z2^>2^>Z2^>5:Z2>:>:Z>:Z>6^>^4N|6N9|^|^2N^2N^|^N|5L|L|L7QL3QL3tL9|L3|L3|L6tLQLtQ5ty2Qy2Qy2QyQtyQ8Lt3yQ2yQy4syI2Cs2ICsICsICsICs5yI2syIs2yI4CsIC2sC7cCGCGCGCGCGCGC2GC15cC3cCcGCc3gGcg13cgcgGc2gGcgGcg7W4UeWUeUWU2eUWU2eUeWUeWUe5W5UeWUeUeU8XU2mXUmXUm2X2UmXUmXU2mUXU3XU3mU2mUXUX2Um3pXpXp5jpjp@pjp2jp6Xp2Xp7@j4@:j:j:@:4j:5@:3j:@:@:@:j@:j@:@:j:@:2@:5>:2>:Z>:Z3>2Z9>2:Z>:Z>:>:>:>:Z:Z2>6Z^7N|^N2|3^N2|^N^N^2N^5|^2|^N|5NL|L|L2|L11QL4NL5|L2|L2|LNL3|L8QL2tLt2Q5tyQtyQtyQtyQ8Lt2Q2Lt7yQty6syI8Cs3I5s2yIsyIsysyIsyIs5ICsIC2sC9GC3cC2GC3cC15IC6GC3GCGCGCc4gGcgGgcg3cg2cg2GcgGc2gG3c3gG2cgcg7We5W2UeWUeUeWUeWUeWUe19WUeUeU2eU6XU2XU2mUmUmXUXUXUXU2mU2mU3XU6mU3XU2XUXUmXUm3pXmpmp18XpmpmpXpmp8jp@3:j2@:@:j:@:2j:2j:@:2j:j:j@:j@:j@2:j@2:j@:j:j:j:3j:4Z:2>:>:>:Z>:Z2>2:Z2>2:Z>:Z>:>:>:2Z:>:2Z:Z:Z:Z>:Z>5Z^>^8|^|^|^N^N^|^14|^2N^N|5N2LNLNL2|L3|L6|L5|L2NL2NLNL2|L|L|L|LNL2NL10tLQLQLt2Q11t8Q2Lt2QLtQLtQLt2Q2Lt5yQty8syI2s2yI4s3yIs2ysysysy2IysysysyIs7ICsCsC2sC16cC9sC4IC4sC5sC4cC3GC2cGCcG2CcgG3cgGcgcgGcgcgG2c2gG15c2gGgGg7egW8Ue3W2Ue4W4e3gW2e2gW2e2gW4Ue2WUeUeUWU12mU2XU2XU2XU2XU3XU7XU13XU3mUmUmXUm2X3m2pXpXp2Xp3Xp3mp2mpmpmpXmpXmpXmpXpXpXp7jp@7:j@:j@:j:j:j@:@:j@:j@2:j2@3:j5@3:j@:j@:@:@:4j:4Z:3Z:>:2Z:Z>:>:Z>:>:Z:Z:Z:>:2Z:2Z:2>:3Z:2Z:>:2Z:Z>:Z2>4Z2^>^Z^11N^13Z^3>^7|^|2^N4L|NL|NLNL2|LNL2NL2NL2NL2NL2|L|L|NLNL|NLNL|NLNLNLNL2|L3NL4tL3QL2tLtQLtQLt2Q3Lt3Q2Lt2QLt2LtQLtLtQLQLtLtQLQLt2Q2Lt3yQ2tyty8sysyIsysyIsysysysy3Iy4Iy3sy2IyIsyI6Cs2CsIC2sC2IC5sC10sC4IC3IC2IC2IC2IC2IC3IC11cC2cCcCcGCc3G4c4gG3c4gG5Cc4G2Cc3G3Cc5gGcgGcg8egWegW2e7gW5e2gWe2gWgWegWgWegWe2gW3eW3UeWUeUeUWU3WU9XU6mU9mU2eU12eU5XU5mU2mUmUmX2Um5pX2mpXmpmpmpmpmpXpXmpX2m2pX2m3pX3m2pXmpmpmp8@jp@3j2@4:j2@2:j@2:j2@3:j11p@8:j2@2:@:j:j:@:4@:4Z:4>:2>:2>:2Z:>:2Z:2Z:2Z:2>:4>:6Z:4Z:3Z:>:2Z:Z>:Z2>5Z2^>^>^Z^3Z^7Z^3Z^2Z^Z^Z^Z^Z^2>^Z^4>^4N|^|3^N2L|2N2L|NLNL|L|L|L|L|NLNLNL|NL|NL|NL|2NL|2NL|2NL|L|NLNL2|L2|L10tL2QL2tLtQLQLtQLQLtQLtQLtLtQLQLQLQL2tLQLQL2tLQLQLQLQLtQLt2Q6t2ytyty11sy2sy3Iy5sy16IyIsyI2s3I3CsICICsCIC2sC2sC2IC3IC3sC2sC2sCIC2sCsCICICICICIC2sC2sC2IC11GC2GCGCGCGCcG2Cc3G4Cc5G3Cc3GCc2GCcGCcGCcG2CcG2Cc2G6c2gGgGg2Gg6WgWegegWegW2egWegWgWegegeg2Wgeg2WgegegegWe2gW5Ue2WUeUeUeU2eU2WU9WU15WU5eU3WU4eU5eU7XU4mU2mUmXUX2Um2X7m3pX2mpX2m2pX3m21pX2m2pmpXp2Xp6@p@jp@j4p@18j3p@2jp@2j2p@2j3p@4:j2@2:j:j@:2j:2j:15Z:4>:4Z:5Z:16Z:9Z:3Z:2Z:Z:Z>:Z2>8Z^>Z^>^>^>^Z^Z^2>^>^>^>Z^Z^>Z^>2Z^>Z^>Z^Z^Z^Z^9|^|^N3|4N3L|2N2L|NL|NL|2NL|2NL|2N3L|5N5L|3N2L|N2L|L|L|L|L2|L4NL3QL5QL3tLQL2tLQLQLQL2tLtLQL2tL2tL2tL2QL3tL2QL3tL2tLQLQLQLQLtQ2Lt7yQtyQyQy2ty15ty4ty3Qy2Qy2ty11IyIsyI8CsICsICsCsIC2sCsCsCICICIC2sCsICICICsICICsICsICICsICICICIC2IC2IC13cC2GC2cCcCcGCcGCcGCcGCcG2CcGCcGCcGCGCcCcGCGCGCcCcCcGCGCcGCcG2Cc3G3c2gGcgGgGg11eg2Wgegeg2Wg2Wg2eg4Wg5eg3eg2WgWgWegW8Ue2WUeUeUeUWU2eU2WU3WU4WU4eU3WU3eU2eU2eU2eUWU2WU2WU2WU3WU14XU2XU2mUmUmXUmX2Um3X15Um6X3Um2X2Um2X3Um3X8m2pXmpmp2Xp8@p@jp@jp@j2p@j2p@2jp@2jp@jp@jpjp@p@jpjp@jp@jp@2j3p@:j4@:j@:j:j:@:2@:4j:34@:8@:14Z:3>:2>:>:>:>:Z>2:Z8^>3Z^>Z2^>Z^>Z^>2Z^>2Z2^>3Z4^>3Z3^>2Z^>Z^>^>^2>^7N^N^N2|2^N12L|5N13|6^N11L|2N2L|NLNLNLNL2NL4|L9tL4QL3QL3QL3tL3tL3QL5tL5QL6QL5tL2QL2QL2tLtLtQLtQ2Lt7yQ2tytyQyQyty2ty2ty2ty2ty2QyQytytyQyQyQyQyQyQyty3Qy7sysyIsyI3s3I3Cs2I2CsICsICsICsICICsICsICs2ICs2ICs2I2Cs2ICs2ICsI2CICsICIC2sCIC2IC14GC3cC2cCGCGCGCGCGCGCGCGCGCGCGCGC2cCcCGC2cCGC2GC2cCcCGCGCGCGCGCcGCc2G9cgGcgcg2Gg4Gg11eg29WgWegWe3gW2Ue3W2UeWUeUeUeUeUeUWU2eUWU2eUWU2WUWU2eUeUWUWUWUWUWUWUWUWUWUWU2eUWU2WU3WU12XU3XU2mUmUmUmXUXUm2XUmX2Um2XUm2X2Um2XUmX2UmXUmXUmXUmXUXUmX2UmXUm2X2Um7pX2mpXpXpXp11jp2@p@p@jpjpjpjpjpjp2@pjp2jp2@p2@pjp2@p@p@jp@jp@4j2@3:j2@:j@:@:@:2j:2j:2@:4j:5@:6@:5@:4@:3@:3@:3@:3@:5j:13>:3>:2>:>:>:>:Z>2:Z>4:Z7^>7Z17>9:Z^>6Z2^>Z^Z^Z^2Z^8N^N^N|^N|2^N|3^N3|3^N3|3^N2|^N2|^N2|^N|^N2|2^N2|10N2L|NL|NLNLNL2|L2NL4NL15tL9QL32QL5QL3tL2tLtLtLtQLtQ2Lt9yQ2tyQtyQtyQtytyQtytyQtyQtyQtyQ2tyQ2tyQt2yQtyQyQtyty2ty10sysyIsyI2s10I3Cs3I3Cs2I3Cs4I6Cs9I5Cs2I2CsI2CICsICIC2sC2sC3sC13cC3GC3GC2GC2GC2GC2GC2GC2GC3cC3cC2GC4cC3cC3cC2cC2cC2cCcCGCcCcGCcG2Cc4Gc4gGcgGcgcgcg2cg3Gg3cg4Gg3Gg2cg2cg2cg2Gg2Gg2Gg3Gg9WgWgWegW2e8W2Ue2WUeWUeWUeUeWUeUeUeWUWUeWUWUeWUWUeWUeWUeWUeWUeWUeWUWUeUeWUWU2eUWU3eU3WU9mU4mU2XU2mUXUXUXUXUXUmUmXUmUmXUXUmUmXUXUmUmUmUmUmUmUmUmUmUmUmXUXUmXUmXUmX2Um8pX2mpXmp2Xp2Xp13jp3jp4@p5jp9jp5@p2@pjpjp@jp@2j8@2:j2@:j:j@:@:@:2j:@:2@:2j:2@:2@:2@:2@:2@:2@:2j:2j:@:2j:@:2j:@:2j:2j:2j:3j:6j:4Z:5>:3Z:>:2Z:Z>:>:Z>:Z2>:Z2>3:Z3>3:Z3>2:Z3>2:Z2>2:Z>2:Z2>:Z2>2:Z3>3:Z5^>3Z^>Z^>^>^2>^10N^|^|^N^N|^N^N|^N|^N^N|^N^N^N|^|^|^|^|^|^N^N|^N|^N|2^N3|4N3L|2NL|NL|L|LNLNL2NL3|L4NL8|L11NL8NL6NL6NL10|L2QL8tL2QL2QL2tLtQLQLtQ2Lt2Q3Lt5yQ4t3yQ3t2yQ3t3yQ5t7yQ6t3yQ2t2yQtyQtyty2ty11IyIyIsyI2s2yI3s7yI10s5yI3s3yI4s4yI9Cs3I2CsICsICICIC2sCIC3sC5IC8GC8cC5cC5GC6GC8GC9GC6GC4cC2GC2cCGC2cGCGCcGCc2G2Cc6gG3cgGcgGcgGgGgGgGgGgGgGgGgGgGcgcgGgGcgcgGcgcgGgGgGgGgGg2Gg11egegWegW2e3gW4Ue4W2Ue2W2Ue2WUe2WUe2WUe2W2Ue2W2Ue3W2Ue3W2Ue2W2UeW2UeWUeWUWUeUeUeUWU2WU3WU15mU3XU3mU2mU2mUXU2mUXU2mUXU2mUXU2mUXU2XU2mU2mU2mU2mUXU2XU2mUXUXUXUXUXUmUmX2UmX2Um7pX2m2pmpXpXpXp2Xp3mp10Xp7mp5Xp4mp16@p@p@jp@j2p@7:j3@:j2@:j:j@:j:j:j:j:j:j:j:j:j:j:j:j:j@:@:@:@:j:j@:@:@:j:j:j:j:j:j:j:@:2@:3j:4j:11Z:3>:3Z:>:2Z:Z:Z:Z>:>:Z>:Z>:Z>:Z>:Z>:Z>:Z:Z>:Z>:Z>:>:Z>:>:Z>:>:Z>:Z>:Z>:Z>2:Z2>11Z2^>Z^Z^Z^2>^15N^2N^|^2|^2N^2N^2N^2|^3N^3N^2|^2|^2N^N^N^N|^N|^N3|7N2L|2NL|NLNL|L|L|LNL2|L2|L2NL3|L3|L3|L3|L3|L3|L2NL3|L2|L2NL3|L2NL3NL4|L7|L4QL6QL3tL2tLQLQLQLtQLQ2LtQLt2Q3Lt5Q8Lt7Q5Lt4Q4Lt4Q7LtyQ6t2yQtyQtyty2Qy12sy2IsysyIsyIsyIsyI2syIs2yIsyI2syIsyIsyIsyIsyIsyIsyIs2yI2s3yI6Cs3I2CsICsICICICIC2sCIC3IC4IC14IC35IC10GC8cC3GC2GC2cCGCGCGCcGCcG2Cc2G12c2gG2c2gG2cgGc2gGc2gGc2gG2c2gG2c2gG2c2gG2cgG2cgGcgGcgGgGgcg2Gg11WgegWgW2egW2e3gW14Ue33W5Ue3W2UeW2UeUeWUWUWUWU2eU2eU3WU18XU5mU3XU4mU3mU3XU3XU4XU4XU4XU4XU4mU3mU2XU2XU2mUXUXUXUmUmXUmX2Um3X7m2pX2mpXmpXpXpXpXpmp2Xpmp2Xpmp2mp2Xpmpmp2XpXpmpmp2Xpmp2Xp2mp5Xp6jp2@p@p@jp@2j2p@7:j3@2:j2@2:j@:j@:j@:j@:j@:j2@:j@:j@:j@2:j@:j@2:j@:j@2:j@:j@:j:j@:@:j:j:@:@:2@:2@:4@:13>:4>:3Z:2Z:>:2Z:>:>:2Z:Z:Z:Z:Z:Z:Z:>:>:>:>:2Z:Z:>:>:2Z:Z:>:>:>:>:>:>:>:Z:Z>:Z>:Z2>:Z4>5Z3^>2Z^>^>^>^Z^2Z^6Z^35N^5|^2|^2N^N^N|^N|2^N10L|2NL|N2LNL|NLNLNLNLNLNLNL2|LNL2|L|LNL2|LNLNL2|LNLNL2|L|L|LNLNL2|L|LNL2|LNL2NL3|L3|L5NL7QL6tL2QL2QL2tLtLQLtLtQLQLtQLtQ2LtQLt2QLt2QLt2QLt2QLtQ2LtQLt2QLtQLtQ2LtQLt2QLt2Q2Lt2Q13t2yQtyQtyty2Qy3Qy9Iy2Iy2IyIysysysysysysy2IyIyIysysy2Iysysy2IyIyIyIsysyIsyIs2yI4s4I4Cs2ICsICsICICICIC2sCIC2IC3sC3sC3IC5sC5sC4IC5sC4IC4IC4sC4IC6sC17GC4GC3cCGC2cCcCcGCGCcGCc2G2Cc2G6Cc8gG13c26gG4c2gGcgGcgGgGgGgcg13WgegegWege2gWegW2e2gW2e3gW2e3gW2e3gW2e2gW2egW2e2gW2e3gW3e12W3Ue2WUeWUeUeWUWU2eUWU2eU3eU4eU26XU15mU19mU7XU4XU3XU2XU2XUXUXUXUXUmXUmXUm2X4Um4pX4m2pX2mpX2mpXmpXpXmpXmpXmpmpXmpXmpXmpXmpXmpXmpXmpXmpmpXpXpXpmp2Xp5Xp5jp2jpjp@p@j2p@j3p@11:j4@4:j3@3:j3@4:j4@4:j4@4:j3@2:j2@2:j@2:j@:j:j@:@:@:@:2j:2j:3j:5j:9>:6>:4Z:3Z:2>:3Z:2Z:2>:2>:2>:3Z:2Z:2>:3Z:2>:3Z:2>:2>:2>:2>:2Z:>:2Z:Z:Z>:>:Z>:Z>:Z2>2:Z9^>2Z^>2^>Z^Z^Z^Z^2>^2>^2Z^3Z^3Z^3Z^3Z^3>^2Z^3>^2Z^4>^15N^|^|^N|^N|2^N3|5N4L|2N2L|NL|2NL|NLNL|NL|L|NLNL|NLNL|NLNL|NLNL|NLNL|NL|L|NL|NLNL|L|NLNLNLNLNL2|LNL2|L2NL3NL9|tL8QL3QL3tLQL2tLQLQL2tLtLtQLQLQLtLtQLQLtLtQLQLtLtLtQLQLQLtLtLtQLQLQLtLtQLtLtQLtQLtQLtQ2Lt2Q12t2yQ2tyQyQyQyty3Qy18Iy3sy4sy5Iy5Iy4Iy3sy3Iysy2IyIyIsyIsyI2s3yI5Cs3I2Cs2ICsICICsCsICIC2sCsCIC2sC2sCIC2IC2IC2IC2IC2IC2sC2sC2sC2sCIC2IC2sC2sC2sC2sC2IC3sC3sC5sC13GC5cC2GC2GC2cCcCcCcCcGCcGCcGCcG2CcG2Cc2G2Cc3G2Cc3G2Cc3G2Cc3G2Cc2G2Cc3G2Cc3G3Cc5G7c4gG2cgGcgGgGgGgcg5Gg7Wg2Wgeg2WgWegegegWegegWegegWegegWegegWgWegegWgWegWgWegWegWe2gWe3gW11Ue3WUeWUeWUeUeUeUeUeUWU2WU3eU3eU4eU6WU9eU10eU8WU8WU27XU4mU2XU2XU2mUmUXUmUmXUmXUmX2Um2X5Um6pX6m4pX3m3pX3m3pX4m3pX4m4pX3m2pX2m2pXmpXmpXmpmpmp2mp3mp9jp2@p@p@jp@jp@jp@2j3p@3j5p@7j7p@6j5p@6j13@4:j2@2:j@:j@:j@:@:j:@:@:2j:2j:3j:4j:20Z:7Z:6Z:5>:6>:7Z:6Z:5>:5Z:3Z:3Z:2Z:>:2Z:>:>:>:>:Z>:Z>:Z2>2:Z12^>2Z^>2Z^>Z^>^>Z^Z^>^>^>^>^>Z^Z^Z^Z^Z^Z^>^>^>Z^Z^Z^Z^Z^Z^2>^>^2>^2Z^13|^2N^N^N|^N2|^N3|10N4L|3N2L|2N2L|2NL|2N2L|N2L|2N2L|N2L|2N2L|2N2L|N2L|2NL|N2L|NL|NL|NLNL|L|L|L|LNL2|L2|L3|L4NL13tL5QL3QL3tL2QL2QL2tL2tLQL2tLQL2tLQL2tLQL2QL2tLQL2tLQL2QL2tLQL2tLQLQL2tLtLtLtLtLtQLtQLQ2LtQLt2Q4Lt4yQ4t2yQtyQtytyty2Qyty3Qy3ty6ty9Qy7Qy8Qy14Iy2IysysysyIsyIs2yI3s6I4Cs2I2CsICsICsICsCsICICsCsCsICICICICICICICICICICICICsCsCsCsCsCsCsCsCsCsCsCsCIC2sCIC2sC2sC2IC4sC7sC4GC7GC4cC2cC2cCGC2cCcCcCcCcGCGCcGCGCcGCcGCcGCGCcGCcGCcGCcGCcGCcGCGCcGCcGCcGCcGCcGCcGCc2GCc2G2Cc3G11c3gGcgGcgGgGgGg2Gg3cg12eg3Wg2eg2eg2Wg2Wg2Wg2Wg2Wg2Wg2Wg2Wg2Wgeg2WgegegegegWgWegW2egW2e12W2Ue2WUeWUeWUeUeUeUeUeUWU2eUWU2WU2WU3eU2WU3eU3eU3eU2WU3WU3WU3eU3eU3eU2WU3WU4eU4WU7eU12mU5XU3XU2XU2XUXU2mUmXUXUmXUmXUmXUm2X2Um2X3Um4X5Um7X7Um6X6Um10X3m7pX3m2pXmpXmpXpXpXpmp3Xp11jp2@pjpjpjp@p@jp@jp@jp@jp@2jp@jp@2jp@jp@2jp@jp@2jp@jp@2jp@j2p@2j2p@3j13@3:j2@:j@:j@:j:j:j:j:j:@:2@:2@:3@:5j:7j:37@:19>:10>:5Z:3Z:2Z:2Z:>:>:>:>:>:Z>:Z>:Z>2:Z2>5:Z4^>5Z3^>3Z2^>Z2^>2Z^>2Z^>2Z^>2Z^>2Z2^>Z2^>Z2^>Z2^>Z^>Z^>Z^>Z^Z^Z^Z^2>^2>^4>^7|^2|^|^|^|^N|^N2|^N3|3^N24L|16N10L|5N3L|2N2L|2NL|NL|NL|NLNL|LNLNL2|LNL3|L3|L5|L14QL7tL4QL4QL4tL3QL3QL4tL3QL4tL3QL3QL4tL3tL2QL3tL2tLQL2QLQL2tLtLtLtQLtLtQLt2QLt2Q5Lt3yQ4t2yQ2tyQtyQtytyQyQytytyty2Qyty2Qyty2ty2Qyty2Qyty2Qyty2Qy2Qy2Qy2Qy3Qy15sy2IyIyIsyIsyIs3yI12Cs3I2Cs2I2CsICs2ICsICsI2CsICsICsICsICsICsI2CsICsICsICsICsICsICsICICsICICsCsCsCsCsCIC2sC2sC2sC3IC6sC9GC6GC4cC2GC3cCGC2GC2cCcCGC2cCcCcCGCGCGCGCGCGC2cCcCcCcCcCGCGCGCGCGCGC2cGCGCGCGCGCcCcGCcGCcGCcGCc2G2Cc2G11c2gG2cgGcgGgGgGgGgcg3Gg4cg35Wg7eg4eg2eg2egegegegWgWe2gWe3gW8Ue4WUe2WUeW2UWUeWUWUeUeUeUeUeUeUeUWUWU2eUeUWU2eUeUWU2eUWUWU2eUWU2eUeUWU2eUWU2eUWU2eU2eUWU3eU2WU3WU5eU17XU4XU3XU2XU2mUXU2mUmUmUmXUXUmXUmXUmXUmXUmXUm2XUmX2UmX2UmXUm2XUm2XUm2XUm2XUmX2Um2XUm2X2Um2X2Um2X4Um10pX3m2pXmpXmpXpXpXpmp3Xp14jp2jp2jp2@p@pjpjpjp2@p@p@p@p@pjpjpjpjpjpjp2@p@jpjpjp@p@jp@jp@jp@2j2p@3j8@4:j2@:j@2:j:j@:j:j:j:j:@:2j:@:2@:2@:3j:3j:4j:4j:4j:5j:4@:5@:5j:5j:5j:6@:23>:5Z:3Z:2Z:>:2Z:>:>:>:Z:Z>:Z>:Z>2:Z2>2:Z3>4:Z21^>14Z11^>5Z4^>2Z2^>2Z^>Z^>Z^Z^Z^Z^2>^3>^11|^2N^|^|^N^N|^N|^N|^N|2^N2|^N3|2^N2|2^N3|2^N3|2^N2|3^N2|3^N3|4^N16L|3N2L|N2L|NL|L|NLNL|LNLNL2|LNL3|L2NL4NL8|L18tL15tL13QL12tL7tL5tL4tL2QL3tLQL2QLQL2tLtQLQLtQLtQLtQLt2Q3Lt11yQ3t3yQt2yQt2yQtyQtyQtyQtytyQtyQtyQtytyQtyQtyQtytyQtytyQtytytytytyty2Qy2ty4Qy10Iy2IyIyIyIsyIsyI2s2yI2s17I5Cs4I3Cs3I4Cs3I3Cs3I3Cs3I3Cs3I2Cs2I2CsI2CsICsICsICsICICICsCsCIC2sCIC2IC3sC4sC22cC4GC4GC3GC3cC2GC3cC2cC2GC2GC2GC3cC2cC2GC2GC2GC3cC2cC2cCGC2GC2cCGC2cCGCGCGCGCGCGCcCcGCcGCc2GCc2G4Cc7gG3c2gG2cgGcgcgGgGgGgGgcg2Gg2Gg2cg3Gg3Gg3Gg3Gg3Gg3Gg3Gg3cg5cg16Wg2WgWgWgWgWegW2egW3e12W3Ue2WOK".replace(
'|',
'\\'
)

val i = StringBuilder()
val p = java.util.LinkedList<Int>()
var l = ' '

for (c in t) {
if (c in '0'..'9') {
i.append(c)
} else {
if (l != ' ') {
val b = l.code - 58
val l = b.shr(3).and(7)
val r = b and 7
repeat(if (i.isNotEmpty()) i.toString().toInt() else 1) {
p.add(l)
p.add(r)
}
}
l = c
i.clear()
}
}

p.removeLast()
p.removeLast()
p.add(3)

val dx = intArrayOf(1, -1, 0, 0, 1, -1, 1, -1)
val dy = intArrayOf(0, 0, 1, -1, 1, -1, -1, 1)

var pos = 500 to 500

for (i in p) {
val (x, y) = pos
val ox = x + dx[i]
val oy = y + dy[i]

v[oy][ox] = '#'
pos = ox to oy
}

for (chars in v) {
sb.append(chars).append('\n')
}
}
9 -> {
val m = ByteBuffer.wrap(
Base64.getDecoder().decode(
"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"
)
)

val dx = intArrayOf(1, 1, 0, -1)
val dy = intArrayOf(0, 1, 1, 1)

data class W(
val x: Int,
val y: Int,
val d: Int,
val len: Int
)

val l = java.util.LinkedList<W>()

while (m.hasRemaining()) {
val n = m.getInt()
l.add(W(n shr 22 and 1023, n shr 12 and 1023, n shr 10 and 3, n and 1023))
}

val n = Array(1003) { CharArray(1003) { '.' } }

for (w in l) {
var (x, y) = w
n[w.y][w.x] = '#'

if (w.len > 1000) {
println(w)
}

for (i in 0..<w.len) {
x += dx[w.d]
y += dy[w.d]

if (x !in 0..1002 || y !in 0..1002)
break
n[y][x] = '#'
}
}

for (chars in n) {
sb.append(chars).append('\n')
}
}
10 -> {
val fib = Array(19) { "" }
fib[0] = "0"
fib[1] = "0 1"

for (i in 2..<19) {
fib[i] = "${fib[i - 1]} ${fib[i - 2]}"
}

sb.append("a_i = a_{i-1} . a_{i-2}\n\n")

for (i in 0..<15) {
val n = "a_${i + 1} = "
val ws = " ".repeat(n.length)
sb.append(n)
for (string in fib[i].chunked(80)) {
if (sb[sb.length - 2] != '=')
sb.append('\n').append(ws)
sb.append(string)
}
sb.append('\n').append('\n')
}

sb.append("\n(A_i)^n = B_i (mod 2)\n\nA_1 = 0   B_1 = 0\n\n")

for (n in 2..70) {
val arr = Array(n) { IntArray(n) }
val a = Array(n) { IntArray(n) { i -> if (it == i) 1 else 0 } }
val b = Array(n) { IntArray(n) }
val t = Array(n) { IntArray(n) }

var c = 0
for (ch in fib.last().take(maxOf(1, (n + n) * n - 1))) {
if (ch == ' ') continue
arr[c / n][c % n] = ch - '0'
b[c / n][c % n] = ch - '0'
c++
}

val ioi = 9099099909999099999L

fun mul(a: Array<IntArray>, b: Array<IntArray>) {
for (i in 0..<n) for (j in 0..<n) t[i][j] = 0
for (i in 0..<n) for (j in 0..<n) for (m in 0..<n) {
t[i][j] += (a[i][m] * b[m][j]) % 2
t[i][j] = t[i][j] % 2
}
for (i in 0..<n) for (j in 0..<n) a[i][j] = t[i][j]
}

mul(a, b)

for (i in 1..63) {
mul(b, b)
if (ioi shr i and 1 == 1L)
mul(a, b)
}

for (i in a.indices) {
val l = "A_$n = ".length
sb.append(if (i == a.size / 2) "A_$n = " else " ".repeat(l))
.append(arr[i].joinToString(" "))
.append(if (i == a.size / 2) "B_$n = ".padStart(l + 3, ' ') else " ".repeat(l + 3))
.append(a[i].joinToString(" ")).append('\n')
}
sb.append('\n')
}
}
}
print(sb)
}
