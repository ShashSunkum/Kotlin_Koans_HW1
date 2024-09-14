class LazyProperty(val initializer: () -> Int) {
    private var _lazy: Int? = null  // Backing field for the lazy property

    val lazy: Int
        get() {
            // Initialize the value if it hasn't been initialized yet
            if (_lazy == null) {
                _lazy = initializer()  // Invoke the initializer
            }
            return _lazy!!  // Return the initialized value
        }
}
