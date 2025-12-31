fun main() = println(
    when (readln()) {
        "fdsajkl;", "jkl;fdsa" -> "in-out"
        "asdf;lkj", ";lkjasdf" -> "out-in"
        "asdfjkl;" -> "stairs"
        ";lkjfdsa" -> "reverse"
        else -> "molu"
    }
)
