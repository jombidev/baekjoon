val g=java.util.StringTokenizer(System.`in`.reader().readText())
val r get()=g.nextToken()
val f get()=1 shl r.toInt()-1
fun main()=with(StringBuilder()){var o=0
repeat(r.toInt()){when(r){"add"->o=o or f
"remove"->o=o and f.inv()
"check"->{append(if(o and f>0)1 else 0).append('\n')}"toggle"->o=o xor f
"all"->o=0.inv()
"empty"->o=0}}
print("$this")}