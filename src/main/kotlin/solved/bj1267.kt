package solved

fun main() {
readln();val s=readln().split(' ').map{it.toInt()}
val(y,m)=s.sumOf{it/30+1}*10 to s.sumOf{it/60+1}*15
print(if(y==m)"Y M $y" else if(y<m)"Y $y" else "M $m")
}
