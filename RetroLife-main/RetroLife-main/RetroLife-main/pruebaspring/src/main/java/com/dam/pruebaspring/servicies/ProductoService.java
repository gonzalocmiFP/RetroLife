package com.dam.pruebaspring.servicies;

import com.dam.pruebaspring.models.Producto;
import com.dam.pruebaspring.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Producto getProductoById(Integer id) {
        return productoRepository.findById(id).get();
    }

    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }
}
