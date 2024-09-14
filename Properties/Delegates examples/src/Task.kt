class LazyProperty(val initializer: () -> Int) {
    private var _lazyValue: Int? = null  // Backing field for lazy value

    // Custom getter for lazyValue
    val lazyValue: Int
        get() {
            if (_lazyValue == null) {  // Check if the value has been initialized
                _lazyValue = initializer()  // Call the initializer
            }
            return _lazyValue!!  // Return the initialized value
        }
}
