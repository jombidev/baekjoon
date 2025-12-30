fun main(){readln();print(readln().split(' ').map{it.toInt()}.run{indices.maxOf{get(it)-size+it}})}
