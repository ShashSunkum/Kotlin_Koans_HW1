import kotlin.random.Random as KRandom
import java.util.Random as JRandom

fun useDifferentRandomClasses(): String {
    return "Kotlin random: " +
            KRandom.nextInt(2) +
            ", Java random: " +
            JRandom().nextInt(2) +
            "."
}

// Example usage
fun main() {
    println(useDifferentRandomClasses())
}
