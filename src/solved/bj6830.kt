fun main()=print(System.`in`.reader().readLines().map{it.split(' ')}.minBy{it[1].toInt()}[0])
