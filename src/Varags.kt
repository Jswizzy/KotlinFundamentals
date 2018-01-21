fun printNames(vararg names: String) {
    for (name in names) println(name)
}

fun greetNames(vararg names: String, greeting: String) {
    for (name in names) println("$greeting $name")
}

fun main(args: Array<String>) {
    val names = listOf("Bill", "Jill", "Tim")
    printNames(*names.toTypedArray())
    greetNames("Bill", "Jill", "Tim", greeting = "Hello")
}