val f=readln().toInt()
fun main()=print(if(f<2)1 else(2..f).reduce{a,b->a*b})
