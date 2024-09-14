// Extension function that mimics the behavior of apply
fun <T> T.myApply(f: T.() -> Unit): T {
    f()  // Invoke the function with the receiver being the current object (this)
    return this  // Return the object itself
}

fun createString(): String {
    return StringBuilder().myApply {
        append("Numbers: ")
        for (i in 1..10) {
            append(i)
        }
    }.toString()
}

fun createMap(): Map<Int, String> {
    return hashMapOf<Int, String>().myApply {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}