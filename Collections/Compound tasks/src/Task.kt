// Find the most expensive product among all the delivered products ordered by the customer.
fun findMostExpensiveProductBy(customer: Customer): Product? {
    return customer.orders
        .filter { it.isDelivered }  // Filter for delivered orders
        .flatMap { it.products }     // Flatten the list of products
        .maxByOrNull { it.price }    // Find the most expensive product
}

// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers.sumOf { customer ->
        customer.orders.sumOf { order ->
            order.products.count { it == product } // Count occurrences of the product in each order
        }
    }
}

// Return all products the given customer has ordered (including duplicates)
fun Customer.getOrderedProducts(): List<Product> =
    orders.flatMap { it.products }  // Flatten the list of products
