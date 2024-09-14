fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
    return date in first..last  // Using range check
}