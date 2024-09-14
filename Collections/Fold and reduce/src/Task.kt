// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> {
    // Get the products ordered by the first customer (if exists)
    val allOrderedProducts = customers.firstOrNull()?.getOrderedProducts() ?: return emptySet()
    // Intersect with the ordered products of each customer
    return customers.fold(allOrderedProducts) { acc, customer ->
        acc.intersect(customer.getOrderedProducts())
    }
}

// Return all products the given customer has ordered
fun Customer.getOrderedProducts(): Set<Product> =
    orders.flatMap { it.products }.toSet()  // Flatten and convert to a Set for uniqueness
