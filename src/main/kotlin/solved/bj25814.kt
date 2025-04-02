fun main()=print(readln().split(' ').map{it.sumOf{it-'0'}*it.length}.reduce(Int::minus).let{when{it>0->1;it<0->2;else->0}})
