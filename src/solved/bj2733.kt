import java.io.EOFException
import java.util.LinkedList

sealed interface Insn {
    fun execute(bf: BF)

    data object NextPtr : Insn {
        override fun execute(bf: BF) {
            bf.ptr = (bf.ptr + 1) % 32768
        }
    }

    data object PrevPtr : Insn {
        override fun execute(bf: BF) {
            bf.ptr = if (bf.ptr - 1 < 0) 32767 else bf.ptr - 1
        }
    }

    data object Inc : Insn {
        override fun execute(bf: BF) {
            bf.b[bf.ptr] = (bf.b[bf.ptr] + 1) % 256
        }
    }

    data object Dec : Insn {
        override fun execute(bf: BF) {
            bf.b[bf.ptr] = if (bf.b[bf.ptr] - 1 < 0) 255 else bf.b[bf.ptr] - 1
        }
    }

    data object Print : Insn {
        override fun execute(bf: BF) {
            bf.sb.append(bf.b[bf.ptr].toChar())
        }
    }

    data class Loop(val insn: List<Insn>) : Insn {
        override fun execute(bf: BF) {
            while (bf.b[bf.ptr] != 0) {
                insn.forEach {
                    it.execute(bf)
                }
            }
        }
    }
}

class BF {
    var ptr = 0
    val b = IntArray(32768)
    val sb = StringBuilder()

    fun execute(str: String): String {
        val iter = str.iterator()
        val insns = LinkedList<Insn>()

        while (true) {
            try {
                insns.add(next(iter))
            } catch (_: EOFException) {
                break
            } catch (_: StackOverflowError) {
                throw IndexOutOfBoundsException()
            }
        }

        for (insn in insns) insn.execute(this)

        return sb.toString()
    }

    private fun next(str: Iterator<Char>): Insn {
        if (!str.hasNext())
            throw EOFException()
        return when (str.next()) {
            '>' -> Insn.NextPtr
            '<' -> Insn.PrevPtr
            '+' -> Insn.Inc
            '-' -> Insn.Dec
            '.' -> Insn.Print
            '[' -> str.parseLooped()
            ']' -> throw IndexOutOfBoundsException()
            else -> next(str)
        }
    }

    fun Iterator<Char>.parseLooped(): Insn {
        val insns = LinkedList<Insn>()

        try {
            while (true) {
                insns.add(next(this))
            }
        } catch (_: IndexOutOfBoundsException) {
            return Insn.Loop(insns)
        } catch (_: EOFException) {
            // should work as OOB
            throw StackOverflowError()
        }
    }
}

fun main() = System.`in`.bufferedReader().use {
    fun r() = it.readLine()
    val n = r().toInt()

    repeat(n) {
        println("PROGRAM #${it + 1}:")

        val opsBuilder = StringBuilder()
        while (true) {
            val insn = r()
            if (insn == "end") break

            for (c in insn) {
                if (c in "><+-.[]")
                    opsBuilder.append(c)
                else if (c == '%')
                    break
            }
        }

        val bf = BF()
        println(
            try {
                bf.execute(opsBuilder.toString())
            } catch (_: IndexOutOfBoundsException) {
                "COMPILE ERROR"
            }
        )
    }
}
