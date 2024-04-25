package solved

import kotlin.let
import kotlin.text.toLong

fun main()=print("${readln().toLong().let{it*it*it}}\n3")