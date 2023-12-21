package solved

fun main()=readln().toBigInteger().run {
    readln().toBigInteger().let { print("${this+it} ${this-it} ${this*it}") }
}