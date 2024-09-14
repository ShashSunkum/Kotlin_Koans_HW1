// Return all products the given customer has ordered
fun Customer.getOrderedProducts(): List<Product> =
        orders.flatMap { it.products }  // Flatten the list of products from all orders

// Return all products that were ordered by at least one customer
fun Shop.getOrderedProducts(): Set<Product> =
        customers.flatMap { it.orders }  // Get all orders from customers
                .flatMap { it.products }       // Get products from those orders
                .toSet()                      // Convert to a Set to ensure uniqueness
