// Find all the different cities the customers are from
fun Shop.getCustomerCities(): Set<City> {
        return customers.map { it.city }.toSet()  // Map customers to their cities and convert to a Set for uniqueness
}

// Find the customers living in a given city
fun Shop.getCustomersFrom(city: City): List<Customer> {
        return customers.filter { it.city == city }  // Filter customers by the specified city
}

