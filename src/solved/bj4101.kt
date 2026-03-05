fun main(){while(true){val(a,b)=readln().split(" ").map{it.toInt()}
if(a==b&&b==0)break
println(if(a>b)"Yes" else "No")}}
