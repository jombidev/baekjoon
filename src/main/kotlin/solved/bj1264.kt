fun main() {
    val mo = "aeiouAEIOU"
    var inp: String
    while (readln().also { inp = it } != "#") {
        println(inp.count { it in mo })
    }
}
