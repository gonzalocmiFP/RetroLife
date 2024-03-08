package com.dam.pruebaspring.controllers;

import com.dam.pruebaspring.models.Direccion;
import com.dam.pruebaspring.servicies.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/direccion")
public class DireccionController {
    @Autowired
    private DireccionService direccionService;

    @GetMapping("/all")
    public List<Direccion> getAllDirecciones() {
        return direccionService.getAllDirecciones();
    }

    @GetMapping("/by-id/{id}")
    public Direccion getDireccion(@PathVariable Integer id) {
        return direccionService.getDireccionById(id);
    }

    @PostMapping("/save")
    public Direccion saveDireccion(@RequestBody Direccion direccion){
        return direccionService.saveDireccion(direccion);
    }
}
