package com.dam.pruebaspring.controllers;

import com.dam.pruebaspring.models.Tarjeta;
import com.dam.pruebaspring.servicies.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarjeta")
public class TarjetaController {
    @Autowired
    private TarjetaService tarjetaService;

    @GetMapping("/all")
    public List<Tarjeta> getAllTarjetas() {
        return tarjetaService.getAllTarjetas();
    }

    @GetMapping("/by-id/{id}")
    public Tarjeta getTarjeta(@PathVariable Integer id) {
        return tarjetaService.getTarjetaById(id);
    }

    @PostMapping("/save")
    public Tarjeta saveTarjeta(@RequestBody Tarjeta tarjeta){
        return tarjetaService.saveTarjeta(tarjeta);
    }
}
