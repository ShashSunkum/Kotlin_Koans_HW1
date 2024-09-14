class PropertyExample {
    var counter = 0
    var propertyWithCounter: Int? = null
        set(value) {
            field = value  // Assign the new value to the backing field
            counter++       // Increment the counter
        }
}
