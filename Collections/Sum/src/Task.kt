// Return the sum of prices for all the products ordered by a given customer
fun moneySpentBy(customer: Customer): Double =
        customer.orders.flatMap { it.products }  // Get all products from the customer's orders
                .sumOf { it.price }  // Sum the prices of those products
