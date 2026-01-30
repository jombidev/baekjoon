fun main() {
    var i = 0
    repeat(readln().toInt()) { if (!readln().contains("CD")) i++ }
    print(i)
}
