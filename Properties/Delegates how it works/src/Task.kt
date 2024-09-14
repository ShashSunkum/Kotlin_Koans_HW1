import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class D {
    var date: MyDate by EffectiveDate()
}

class EffectiveDate<R> : ReadWriteProperty<R, MyDate> {

    private var timeInMillis: Long? = null

    override fun getValue(thisRef: R, property: KProperty<*>): MyDate {
        // Return the date by converting timeInMillis to MyDate
        return timeInMillis?.toDate() ?: MyDate(0, 0, 0) // Default value or handle as needed
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: MyDate) {
        // Store the time in milliseconds
        timeInMillis = value.toMillis()
    }
}
