package com.example.inventario_productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventario_productos.exceptions.ResourceNotFoundException;
import com.example.inventario_productos.model.Producto;
import com.example.inventario_productos.repository.ProductoRepository;


@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException
        ("Producto con ID: " + id + " no encontrado en la base de datos"));
    }

    public List<Producto> obtenerPorNombre(String nombre) {
       List<Producto> resultados = productoRepository.findByNombreContainingIgnoreCase(nombre);
       if(resultados.isEmpty()){
        throw new ResourceNotFoundException("Producto con nombre: " + nombre + " no encontrado en la base de datos");
       }
       return resultados;
    }

    public Producto agregar(Producto producto) {
        if(producto.getPrecio() < 0 || producto.getCantidad() < 0) {
            throw new IllegalArgumentException("Precio o cantidad no valida");
        }
        return productoRepository.save(producto);
    }

    public Producto actualizar(Long id, Producto nuevoProducto) {
        return productoRepository.findById(id)
        .map(producto-> {
            producto.setNombre(nuevoProducto.getNombre());
            producto.setPrecio(nuevoProducto.getPrecio());
            producto.setCantidad(nuevoProducto.getCantidad());
            return productoRepository.save(producto);
        })
        .orElseThrow(()-> new ResourceNotFoundException("Producto con ID: " + id + " no encontrado en la base de datos"));
    }

    public void eliminar(Long id){
        productoRepository.deleteById(id);
    }


}
