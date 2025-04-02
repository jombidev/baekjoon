fun main()=print(readln().split(' ').sumOf{it.toLong()}.let{val a=readln().toLong();if(it>=a*2)it-a*2 else it})
