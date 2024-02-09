package com.dam.pruebaspring.controllers;

import com.dam.pruebaspring.models.Producto;
import com.dam.pruebaspring.servicies.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/all")
    public List<Producto> getAllProducts() {
        return productoService.getAllProducts();
    }

    @GetMapping("/by-id/{id}")
    public Producto getProduct(@PathVariable Integer id) {
        return productoService.getProductById(id);
    }

    @PostMapping("/save")
    public Producto saveProducto(@RequestBody Producto producto){
        return productoService.saveProducto(producto);
    }
}
