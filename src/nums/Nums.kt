package nums

val numbers = listOf(1, 2, 3)
val mNumbers = listOf(1, 2, 3)

typealias People = Map<String,Int>

val people: People = mapOf("John" to 23, "Jill" to 25)

fun main(args: Array<String>) {
    for (p in people) println(p)

    for (i in 1..100) println(i)
}
