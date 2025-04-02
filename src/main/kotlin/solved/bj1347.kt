fun main() {
    readln()
    val o = Array(100) { Array(100) { '#' } }
    var startX = 50
    var startY = 50 // idk where hong jun is
    var minX = minOf(101, startX);var minY = minOf(101, startY);var maxX = maxOf(-1, startX);var maxY = maxOf(-1, startY)

    o[startY][startX] = '.'
    var facing = Facing.DOWN
    for (c in readln()) {
        when (c) {
            'L' -> facing = facing.left()
            'R' -> facing = facing.right()
            'F' -> {
                startX += facing.offsetY
                startY += facing.offsetX
                minX = minOf(minX, startX)
                minY = minOf(minY, startY)
                maxX = maxOf(maxX, startX)
                maxY = maxOf(maxY, startY)
                o[startX][startY] = '.'
            }
        }
    }
    for (i in minX..maxX) {
        for (j in minY..maxY) {
            print(o[i][j])
        }
        println()
    }
}

enum class Facing(val offsetX: Int, val offsetY: Int) {
    UP(0, -1), DOWN(0, 1),
    LEFT(-1, 0), RIGHT(1, 0)
    ;
    fun left() = when (this) {
        UP -> LEFT
        LEFT -> DOWN
        DOWN -> RIGHT
        RIGHT -> UP
    }
    fun right() = when (this) {
        UP -> RIGHT
        RIGHT -> DOWN
        DOWN -> LEFT
        LEFT -> UP
    }
}
