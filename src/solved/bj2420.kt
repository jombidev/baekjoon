fun main()=print(Math.abs(readln().split(' ').map{it.toLong()}.reduce{ a, b->a-b}))
