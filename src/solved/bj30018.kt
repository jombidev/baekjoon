fun main(){fun r()=readln().split(' ').map{it.toInt()}
r()
val a=r()
print(r().mapIndexed{i,n->a[i]-n}.sumOf{maxOf(0,it)})}
