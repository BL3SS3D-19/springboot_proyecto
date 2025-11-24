package com.example.inventario_productos.model;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="productos")
@Getter
@Setter

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private double precio;
    private int cantidad;

    
    public Producto() {
    }


    public Producto(String nombre, double precio, int cantidad){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public void mostrarInfo() {
        System.out.println(
            "Producto:  " + nombre +
            " , Precio: " + precio + 
            " , Cantidad: " + cantidad
        );
    }
}
