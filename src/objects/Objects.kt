package objects

import java.time.LocalDate

data class Customer(val name: String)

interface CustomerEventListener {
    fun save(customer: Customer, created: LocalDate)
    fun delete(customer: Customer)
}

class CustomerService {
    companion object Comp {
        private val listeners = mutableListOf<CustomerEventListener>()
        @JvmStatic
        fun addListener(listener: CustomerEventListener) {
            listeners.add(listener)
        }

    }

    fun save(customer: Customer) {
        val data = gatherData(customer)
        data.x = 43
        val created = data.created
        listeners.forEach { it.save(customer, created) }
    }


    fun delete(customer: Customer) {
        listeners.forEach { it.delete(customer) }
    }

    private fun gatherData(customer: Customer) = object {
        val created = LocalDate.now()
        var x = 42
    }


}

fun main(args: Array<String>) {
    val service = CustomerService()
    CustomerService.addListener(object : CustomerEventListener {
        override fun save(customer: Customer, created: LocalDate) {
            println("$created saved: $customer")
        }

        override fun delete(customer: Customer) {
            println("deleted: $customer")
        }
    })
    service.save(Customer("John"))
}