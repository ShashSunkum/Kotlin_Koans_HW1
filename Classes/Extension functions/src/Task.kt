data class RationalNumber(val numerator: Int, val denominator: Int)

fun Int.r(): RationalNumber {
    return RationalNumber(this, 1)  // An integer can be represented as a rational number with a denominator of 1
}

fun Pair<Int, Int>.r(): RationalNumber {
    return RationalNumber(this.first, this.second)  // Use the first and second elements as numerator and denominator
}

// Example usage
fun main() {
    val intAsRational = 5.r()  // Converts Int to RationalNumber
    val pairAsRational = Pair(3, 4).r()  // Converts Pair to RationalNumber

    println(intAsRational)  // Output: RationalNumber(numerator=5, denominator=1)
    println(pairAsRational)  // Output: RationalNumber(numerator=3, denominator=4)
}
