package com.gustavo.miproyect1

fun main() {
    // Definición de variables de producto
    val productId: Int = 101
    val productName: String = "Smartphone X1"
    var productDescription: String? = null
    var stockQuantity: Int = 25
    val unitPrice: Double = 599.99

    println("--- Datos Iniciales Cargados ---")

    // Lógica de Impuestos
    val TAX_RATE = 0.15
    val totalPriceWithTax = unitPrice * (1 + TAX_RATE)

    // Uso del Operador Elvis (?:)
    val descriptionToShow = productDescription ?: "Sin descripción disponible"
    println("Producto: $productName")
    println("Descripción: $descriptionToShow")

    // Simulación de Venta
    val itemsSold = 5
    stockQuantity -= itemsSold

    // Generación de Reporte con Plantilla de Cadena
    val report = """
        --- REPORTE DE INVENTARIO ---
        ID: $productId | Nombre: $productName
        Precio Final: ${'$'}${String.format(java.util.Locale.US, "%.2f", totalPriceWithTax)}
        Stock Actual: $stockQuantity
        Estado: ${if (stockQuantity > 10) "Suficiente" else "Crítico"}
        -----------------------------
    """.trimIndent()

    println(report)
}