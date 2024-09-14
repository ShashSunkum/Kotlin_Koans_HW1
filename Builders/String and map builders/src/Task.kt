fun <K, V> buildMutableMap(build: HashMap<K, V>.() -> Unit): HashMap<K, V> {
    val map = HashMap<K, V>() // Create a new HashMap
    map.build() // Invoke the lambda on the map
    return map // Return the populated map
}

fun usage(): Map<Int, String> {
    return buildMutableMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}