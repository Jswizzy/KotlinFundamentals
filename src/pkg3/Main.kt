package pkg3

import pkg1.Greeter as G1
import pkg2.Greeter as G2

fun main(args: Array<String>) {
    println(G1().Hello())
    println(G2().Hello())
}