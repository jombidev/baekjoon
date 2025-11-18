fun main()=print(List(readln().toInt()){it+1}.reduceOrNull{a,b->a*b}?:1)
