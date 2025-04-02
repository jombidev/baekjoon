fun main()=String(System.`in`.readBytes()).split('\n').filter{!it.isBlank()}.forEach{println("DCBAE"[it.trim().split(' ').sumOf{it.toInt()}])}
