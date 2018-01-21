package nums

val numbers2 = (1..100).toList()

fun main(args: Array<String>) {
    val mod9 = numbers2.filter { it % 9 == 0 }
    val notMod9 = numbers2.filterNot { it % 9 == 0 }
    val lastMod9 = numbers2.last { it % 9 == 0 }
    val firstMod9 = numbers2.first { it % 9 == 0}
    val firstOver100 = numbers2.find { it > 100 }
    val lastUnder50 = numbers2.findLast { it < 50 }
    val noNegatives = numbers2.none { it < 0 }

    println(mod9)

    val tmp = numbers2.asSequence()
            .filter { it % 9 == 0 }
            .filterNot { it == 36 }

    for (n in tmp) println(n)
 }
