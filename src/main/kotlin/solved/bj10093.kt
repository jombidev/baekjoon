package solved

private val o=java.math.BigInteger.ONE
fun main()=readln().split(' ').map{it.toBigInteger()}.let{it.min()+ o..<it.max()}.run{println(maxOf(o - o,endExclusive-start))
for (i in object:Iterator<Any>{var c=start
override fun hasNext()=c<endExclusive
override fun next()=c++})print("$i ")}
