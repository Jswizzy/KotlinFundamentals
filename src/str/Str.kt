package str

import java.time.LocalTime

val strings = listOf(
        "Hello",
        "Hello\nWorld",
        "The time is now ${LocalTime.now()}",
        """Multiline
            line 1
            line 2
            """,
        """Multiline
            |line 1
            |line 2
            """.trimMargin()
)

fun main(args: Array<String>) {
    strings.forEach(::println)
}