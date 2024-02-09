package com.dam.pruebaspring.controllers;

import com.dam.pruebaspring.models.Pedido;
import com.dam.pruebaspring.servicies.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/all")
    public List<Pedido> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }

    @GetMapping("/by-id/{id}")
    public Pedido getPedido(@PathVariable Integer id) {
        return pedidoService.getPedidoById(id);
    }

    @PostMapping("/save")
    public Pedido savePedido(@RequestBody Pedido pedido){
        return pedidoService.savePedido(pedido);
    }
}
