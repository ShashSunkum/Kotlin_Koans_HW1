sealed interface Expr

class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(expr: Expr): Int =
    when (expr) {
        is Num -> expr.value  // Smart cast to Num
        is Sum -> eval(expr.left) + eval(expr.right)  // Smart cast to Sum
    }

// Example usage
fun main() {
    val expression = Sum(Num(1), Sum(Num(2), Num(3))) // Represents 1 + (2 + 3)
    println(eval(expression))  // Output: 6
}
