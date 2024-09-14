import java.util.*

fun <T, C1 : MutableCollection<in T>, C2 : MutableCollection<in T>>
        Collection<T>.partitionTo(
    collection1: C1,
    collection2: C2,
    predicate: (T) -> Boolean
): Pair<C1, C2> {
    for (item in this) {
        if (predicate(item)) {
            collection1.add(item) // Add to the first collection if the predicate is true
        } else {
            collection2.add(item) // Add to the second collection if the predicate is false
        }
    }
    return Pair(collection1, collection2) // Return both collections
}

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e")
            .partitionTo(ArrayList(), ArrayList()) { s -> !s.contains(" ") }
    check(words == listOf("a", "c"))
    check(lines == listOf("a b", "d e"))
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}')
            .partitionTo(HashSet(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
    check(letters == setOf('a', 'r'))
    check(other == setOf('%', '}'))
}
