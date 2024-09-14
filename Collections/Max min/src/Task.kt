// Return a customer who has placed the maximum amount of orders
fun Shop.getCustomerWithMaxOrders(): Customer? {
        return customers.maxByOrNull { it.orders.size }  // Use maxByOrNull to find the customer with the most orders
}

// Return the most expensive product that has been ordered by the given customer
fun getMostExpensiveProductBy(customer: Customer): Product? {
        return customer.orders.flatMap { it.products }  // Get all products ordered by the customer
                .maxByOrNull { it.price }  // Find the product with the maximum price
}
