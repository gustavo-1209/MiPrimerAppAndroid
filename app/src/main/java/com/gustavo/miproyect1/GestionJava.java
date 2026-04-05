package com.gustavo.miproyect1;

import java.util.HashSet;
import java.util.Scanner;

public class GestionJava {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Registro de Producto (Java) ===");

        System.out.print("Ingrese ID: ");
        String id = scanner.nextLine();

        System.out.print("Ingrese Nombre: ");
        String nombre = scanner.nextLine();

        // Riesgo de NullPointerException
        if (nombre != null) {
            nombre = nombre.toUpperCase();
        }

        System.out.print("Ingrese Precio: ");
        double precio = scanner.nextDouble();

        Producto p1 = new Producto(id, nombre, precio);

        // Clasificación
        String categoria;

        if (precio > 500) {
            categoria = "Premium";
        } else if (precio >= 100 && precio <= 500) {
            categoria = "Estándar";
        } else {
            categoria = "Económico";
        }

        System.out.println("\nProducto ingresado:");
        System.out.println(p1);
        System.out.println("Categoría: " + categoria);

        // Crear segundo objeto igual
        Producto p2 = new Producto(id, nombre, precio);

        System.out.println("\nComparación de objetos:");
        System.out.println("p1 == p2: " + (p1 == p2));
        System.out.println("p1.equals(p2): " + p1.equals(p2));

        // Uso de HashSet
        HashSet<Producto> set = new HashSet<>();
        set.add(p1);

        System.out.println("\n¿El set contiene p2?: " + set.contains(p2));
    }
}