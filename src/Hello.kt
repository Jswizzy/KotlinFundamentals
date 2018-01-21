class Person(val name: String, var age: Int) {

    fun nextAge() = age + 1

    fun olderThan(other: Person) = age > other.age

    override fun toString() =
            "$name is $age years old"

    override fun equals(other: Any?): Boolean {
        return (other is Person && name == other.name)
    }
}

fun main(args: Array<String>) {
    val person1 = Person("John Doe", 42)
    val person2 = Person("Mary Jane", 30)
    println("Hello ${person1.name} next year you will be ${person1.nextAge()}!")
    println(person2)
}

