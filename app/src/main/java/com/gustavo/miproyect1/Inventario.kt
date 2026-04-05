package com.gustavo.miproyect1

import java.util.Scanner

data class ProductoK(val id: String, val nombre: String, val precio: Double)

fun main() {
    val lector = Scanner(System.`in`)
    println("--- Registro de Inventario Kotlin ---")

    print("Ingrese ID del producto: ")
    val idInput = lector.next()

    print("Ingrese Nombre del producto: ")
    val nombreInput = readLine() ?: "Sin Nombre"

    print("Ingrese Precio: ")
    val precioInput = lector.nextDouble()

    val p1 = ProductoK(idInput, nombreInput, precioInput)

    val categoria = when {
        p1.precio > 500.0 -> "Premium"
        p1.precio in 100.0..500.0 -> "Estándar"
        else -> "Económico"
    }

    println("\nProducto Registrado con éxito:")
    println(p1)
    println("Categoría asignada: $categoria")

    val p2 = ProductoK(idInput, nombreInput, precioInput)
    println("\n¿Contenido idéntico?: ${p1 == p2}")
}