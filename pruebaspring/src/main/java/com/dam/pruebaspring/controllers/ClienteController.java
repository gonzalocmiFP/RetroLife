package com.dam.pruebaspring.controllers;

import com.dam.pruebaspring.models.Cliente;
import com.dam.pruebaspring.servicies.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/all")
    public List<Cliente> getAllProducts() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/by-id/{id}")
    public Cliente getCliente(@PathVariable Integer id) {
        return clienteService.getClienteById(id);
    }

    @PostMapping("/save")
    public Cliente saveCliente(@RequestBody Cliente cliente){
        return clienteService.saveCliente(cliente);
    }
}
