fun main()=repeat(readln().toInt()){val(a,b)=readln().split(' ').map{it.toInt()}
println(if(a.countOneBits()%2==b)"Valid" else "Corrupt")}
