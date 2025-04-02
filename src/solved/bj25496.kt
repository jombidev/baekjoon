fun main() {
    var dura = readln().split(' ')[0].toInt()
    var cnt = 0
    for (it in readln().split(' ').map { it.toInt() }.sorted()) {
        if (dura > 199) break
        dura += it
        cnt++
    }
    print(cnt)
}
