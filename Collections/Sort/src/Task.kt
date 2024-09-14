fun Shop.getCustomersSortedByOrders(): List<Customer> {
        return customers.sortedByDescending { it.orders.size }  // Sort customers by the size of their orders list in descending order
}