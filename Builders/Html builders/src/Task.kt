fun renderProductTable(): String {
    return html {
        table {
            // Header row
            tr(getTitleColor()) {
                td {
                    text("Product")
                }
                td {
                    text("Price")
                }
                td {
                    text("Popularity")
                }
            }
            // Retrieve the list of products
            val products = getProducts()
            // Populate the table with product data
            for ((index, product) in products.withIndex()) {
                val rowColor = getCellColor(index, 0) // Get color for the row
                tr(rowColor) {
                    td(getCellColor(index, 0)) { // Product column
                        text(product.description)
                    }
                    td(getCellColor(index, 1)) { // Price column
                        text(product.price)
                    }
                    td(getCellColor(index, 2)) { // Popularity column
                        text(product.popularity)
                    }
                }
            }
        }
    }.toString()
}

fun getTitleColor() = "#b9c9fe"  // Color for the table header

fun getCellColor(index: Int, column: Int): String {
    return if ((index + column) % 2 == 0) "#dce4ff" else "#eff2ff"
}