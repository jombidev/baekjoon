fun main()=repeat(readln().toInt()){var n=readln().toInt()
for(i in listOf(25,10,5,1)){print("${n/i} ")
n%=i}
println()}
