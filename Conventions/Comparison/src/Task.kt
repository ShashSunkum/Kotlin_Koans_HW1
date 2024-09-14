data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        // Compare by year first
        if (this.year != other.year) {
            return this.year - other.year
        }
        // If years are the same, compare by month
        if (this.month != other.month) {
            return this.month - other.month
        }
        // If months are the same, compare by day
        return this.dayOfMonth - other.dayOfMonth
    }
}

fun test(date1: MyDate, date2: MyDate) {
    // this code should compile:
    println(date1 < date2)
}

// Example usage
fun main() {
    val date1 = MyDate(2024, 9, 13)
    val date2 = MyDate(2023, 9, 13)

    test(date1, date2)  // Output: false
}
