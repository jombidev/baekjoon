fun main(){readln()
val n=IntArray(5)
for(c in readln())"uospc".indexOf(c).let{if(it!=-1)n[it]++}
print(n.min())}
