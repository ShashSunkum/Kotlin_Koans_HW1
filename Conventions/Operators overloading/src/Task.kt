import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

enum class TimeInterval { DAY, WEEK, YEAR }

// Class to hold time interval and amount
data class TimeIntervalAmount(val interval: TimeInterval, val amount: Int) {
    operator fun plus(other: TimeIntervalAmount): TimeIntervalAmount {
        if (this.interval == other.interval) {
            return TimeIntervalAmount(this.interval, this.amount + other.amount)
        }
        return this // No need to handle different intervals in plus operation
    }
}

// Operator function to add a single TimeInterval to MyDate
operator fun MyDate.plus(timeIntervalAmount: TimeIntervalAmount): MyDate {
    return this.addTimeIntervals(timeIntervalAmount.interval, timeIntervalAmount.amount)
}

// Operator function to handle adding of TimeInterval with an integer
operator fun TimeInterval.times(times: Int): TimeIntervalAmount {
    return TimeIntervalAmount(this, times)
}

// Function to handle addition of multiple intervals
operator fun MyDate.plus(vararg timeIntervalAmounts: TimeIntervalAmount): MyDate {
    var resultDate = this
    for (timeIntervalAmount in timeIntervalAmounts) {
        resultDate = resultDate + timeIntervalAmount
    }
    return resultDate
}

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    // Uncommented implementation for adding multiple time intervals
    return today + (YEAR * 2) + (WEEK * 3) + (DAY * 5)
}
