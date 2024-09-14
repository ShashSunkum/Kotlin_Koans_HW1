// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> =
    customers.filter { customer ->
        val deliveredCount = customer.orders.count { it.isDelivered }
        val undeliveredCount = customer.orders.count { !it.isDelivered }
        undeliveredCount > deliveredCount
    }.toSet()  // Convert the result to a Set for uniqueness
