private val a=List(3){readln().toInt()}.reduce(Int::times).toString()
fun main()=repeat(10){b->println(a.count{it=='0'+b})}
