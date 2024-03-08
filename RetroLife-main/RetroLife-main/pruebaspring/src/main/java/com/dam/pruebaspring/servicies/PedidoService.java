package com.dam.pruebaspring.servicies;

import com.dam.pruebaspring.models.Pedido;
import com.dam.pruebaspring.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido getPedidoById(Integer id) {
        return pedidoRepository.findById(id).get();
    }

    public Pedido savePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}
