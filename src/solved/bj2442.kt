fun main()=readln().toInt().let{for(i in it downTo 1)println(" ".repeat(it-i)+"*".repeat(i*2-1))}
