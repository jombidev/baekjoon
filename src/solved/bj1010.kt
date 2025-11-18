fun main()=repeat(readln().toInt()){println(readln().split(' ').map{it.toInt()}.let{(k,n)->f(n)/(f(k)*f(n-k))})}
fun f(d:Int)=List(d){(it+1L).toBigInteger()}.reduceOrNull{a,b->a*b}?:1L.toBigInteger()
