package com.dam.pruebaspring.controllers;

import com.dam.pruebaspring.models.Carrito;
import com.dam.pruebaspring.servicies.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito")
public class CarritoController {
    @Autowired
    private CarritoService carritoService;

    @GetMapping("/all")
    public List<Carrito> getAllCarritos() {
        return carritoService.getAllCarritos();
    }

    @GetMapping("/by-id/{id}")
    public Carrito getCarrito(@PathVariable Integer id) {
        return carritoService.getCarritoById(id);
    }

    @PostMapping("/save")
    public Carrito saveCarrito(@RequestBody Carrito carrito){
        return carritoService.saveCarrito(carrito);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteCarrito(@PathVariable Integer id) {return carritoService.deleteCarrito(id);}
}
