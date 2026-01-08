fun main() {
    val n = readln().toInt()

    val s = Array(n) { readln().split(' ').map { it.toInt() }.toIntArray() }
    var max = s.maxOf { it.max() }

    fun dfs(depth: Int, array: Array<IntArray>) {
        if (depth == 10)
            return

        val work = Array(n) { array[it].copyOf() }

        fun reset() {
            for ((i, w) in work.withIndex()) {
                for (j in w.indices) {
                    work[i][j] = array[i][j]
                }
            }
        }

        for (x in 0..<n) {
            fun moveUp(start: Int = 0) {
                var zeroY = -1
                for (y in start..<n - 1) {
                    if (work[y][x] == 0) {
                        zeroY = y
                        break
                    }
                }

                if (zeroY == -1) return

                for (y in zeroY + 1..<n) {
                    if (work[y][x] != 0) {
                        work[zeroY][x] = work[y][x]
                        work[y][x] = 0
                        zeroY++
                    }
                }
            }

            moveUp()
            for (y in 0..<n - 1) {
                if (work[y][x] == 0)
                    break

                if (work[y][x] == work[y + 1][x]) {
                    work[y][x] *= 2
                    max = maxOf(max, work[y][x])
                    work[y + 1][x] = 0
                    moveUp(y)
                }
            }
        }
        dfs(depth + 1, work)
        reset()

        for (x in 0..<n) {
            fun moveDown(start: Int = n - 1) {
                var zeroY = -1
                for (y in start downTo 1) {
                    if (work[y][x] == 0) {
                        zeroY = y
                        break
                    }
                }

                if (zeroY == -1) return

                for (y in zeroY - 1 downTo 0) {
                    if (work[y][x] != 0) {
                        work[zeroY][x] = work[y][x]
                        work[y][x] = 0
                        zeroY--
                    }
                }
            }

            moveDown()
            for (y in n - 1 downTo 1) {
                if (work[y][x] == 0)
                    break

                if (work[y][x] == work[y - 1][x]) {
                    work[y][x] *= 2
                    max = maxOf(max, work[y][x])
                    work[y - 1][x] = 0
                    moveDown(y)
                }
            }
        }
        dfs(depth + 1, work)
        reset()

        for (y in 0..<n) {
            fun moveLeft(start: Int = 0) {
                var zeroX = -1
                for (x in start..<n - 1) {
                    if (work[y][x] == 0) {
                        zeroX = x
                        break
                    }
                }

                if (zeroX == -1) return

                for (x in zeroX + 1..<n) {
                    if (work[y][x] != 0) {
                        work[y][zeroX] = work[y][x]
                        work[y][x] = 0
                        zeroX++
                    }
                }
            }

            moveLeft()
            for (x in 0..<n - 1) {
                if (work[y][x] == 0)
                    break

                if (work[y][x] == work[y][x + 1]) {
                    work[y][x] *= 2
                    max = maxOf(max, work[y][x])
                    work[y][x + 1] = 0
                    moveLeft(x)
                }
            }
        }
        dfs(depth + 1, work)
        reset()

        for (y in 0..<n) {
            fun moveRight(start: Int = n - 1) {
                var zeroX = -1
                for (x in start downTo 1) {
                    if (work[y][x] == 0) {
                        zeroX = x
                        break
                    }
                }

                if (zeroX == -1) return

                for (x in zeroX - 1 downTo 0) {
                    if (work[y][x] != 0) {
                        work[y][zeroX] = work[y][x]
                        work[y][x] = 0
                        zeroX--
                    }
                }
            }

            moveRight()
            for (x in n- 1 downTo 1) {
                if (work[y][x] == 0)
                    break

                if (work[y][x] == work[y][x - 1]) {
                    work[y][x] *= 2
                    max = maxOf(max, work[y][x])
                    work[y][x - 1] = 0
                    moveRight(x)
                }
            }
        }
        dfs(depth + 1, work)
        reset()
    }

    dfs(0, s)
    print(max)
}
