package com.example.inventario_productos.model;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table (name="productos_electronicos")
@Getter
@Setter
public class ProductoElectronico extends Producto{

    private String marca;
    private String modelo;

    public ProductoElectronico() {
        super();
    }

    public ProductoElectronico(String nombre, double precio, int cantidad, String marca, String modelo ) {
        super(nombre, precio, cantidad);
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public void mostrarInfo() {
        System.out.println(
            "Producto Electronico: " + getNombre() + 
            ", Marca: " + marca + 
            ", Modelo: " + modelo + 
            ", Precio: " + getPrecio() + 
            ", Cantidad: " + getCantidad()
        );
    }
}
