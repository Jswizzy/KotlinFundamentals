package more

import java.net.InetAddress
import java.net.UnknownHostException

fun isValidIP(host: String) = try {
    InetAddress.getByName(host)
    true
} catch (e: UnknownHostException) {
    false
}

fun main(args: Array<String>) {
    println(isValidIP("www.google.com"))
}