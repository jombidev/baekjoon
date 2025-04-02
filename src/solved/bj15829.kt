fun main(){readln()
    print(readln().foldRight(0L){c,v->(c-'`'+31*v)%1234567891})}
