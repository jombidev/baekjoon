fun main()=String(System.`in`.readBytes()).trim().split('\n').map{it.toInt()}.filter{it%2==1}.run{println(if(size>0)"${sum()}\n${min()}" else "-1")}
