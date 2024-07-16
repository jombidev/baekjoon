package solved

fun main()=String(System.`in`.readBytes()).trim().split('\n').map{it.toInt()}.run{print("${average().toInt()}\n${sorted()[2]}")}
