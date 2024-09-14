open class Tag(val name: String) {
    protected val children = mutableListOf<Tag>()

    override fun toString() =
        "<$name>${children.joinToString("")}</$name>"
}

fun table(init: TABLE.() -> Unit): TABLE {
    val table = TABLE()
    table.init()
    return table
}

class TABLE : Tag("table") {
    fun tr(init: TR.() -> Unit) {
        val row = TR() // Create a new TR instance
        row.init()    // Initialize it using the provided lambda
        children.add(row) // Add the row to the table's children
    }
}

class TR : Tag("tr") {
    fun td(init: TD.() -> Unit) {
        val cell = TD() // Create a new TD instance
        cell.init()     // Initialize it using the provided lambda
        children.add(cell) // Add the cell to the row's children
    }
}

class TD : Tag("td")

fun createTable() =
    table {
        tr {
            repeat(2) {
                td {
                    // You can put content inside td if needed
                }
            }
        }
    }

fun main() {
    println(createTable()) // Output: <table><tr><td></td><td></td></tr></table>
}
