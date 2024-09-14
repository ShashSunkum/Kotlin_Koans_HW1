class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            private var current: MyDate? = start

            override fun hasNext(): Boolean {
                return current != null && current <= end
            }

            override fun next(): MyDate {
                val nextDate = current ?: throw NoSuchElementException()
                current = nextDate.followingDate()
                return nextDate
            }
        }
    }
}