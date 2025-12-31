fun main()=print(readln().let{if(it=="F").0 else 'E'-it[0]+when(it[1]){'+'->.3 '-'->-.3 else->.0}})
