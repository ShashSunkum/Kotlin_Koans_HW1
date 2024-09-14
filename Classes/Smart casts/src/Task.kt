fun eval(expr: Expr): Int =
    when (expr) {
        is Num -> expr.value  // Smart cast to Num
        is Sum -> eval(expr.left) + eval(expr.right)  // Smart cast to Sum
        else -> throw IllegalArgumentException("Unknown expression")
    }

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr
