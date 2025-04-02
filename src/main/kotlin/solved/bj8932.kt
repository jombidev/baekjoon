package solved

private val a=listOf(9.23076,1.84523,56.0211,4.99087,0.188807,15.9803,0.11193)
private val b=listOf(26.7,75.0,1.5,42.5,210.0,3.8,254.0)
private val c=listOf(1.835,1.348,1.05,1.81,1.41,1.04,1.88)
fun main()=List(readln().toInt()){readln().split(" ").map{it.toInt()}.mapIndexed{i,s->(a[i]*Math.pow(Math.abs(b[i]-s),
    c[i])).toInt()}.sum()}.forEach(::println)
