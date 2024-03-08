package com.dam.pruebaspring.servicies;

import com.dam.pruebaspring.models.Carrito;
import com.dam.pruebaspring.repositories.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoService {
    @Autowired
    private CarritoRepository carritoRepository;

    public List<Carrito> getAllCarritos() {
        return carritoRepository.findAll();
    }

    public Carrito getCarritoById(Integer id) {
        return carritoRepository.findById(id).get();
    }

    public Carrito saveCarrito(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    public  Boolean deleteCarrito(Integer id) {
        carritoRepository.deleteById(id);
        return carritoRepository.findById(id).isEmpty();
    }
}