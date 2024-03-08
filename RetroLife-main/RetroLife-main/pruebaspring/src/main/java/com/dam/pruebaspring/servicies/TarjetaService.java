package com.dam.pruebaspring.servicies;

import com.dam.pruebaspring.models.Tarjeta;
import com.dam.pruebaspring.repositories.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarjetaService {
    @Autowired
    private TarjetaRepository tarjetaRepository;

    public List<Tarjeta> getAllTarjetas() {
        return tarjetaRepository.findAll();
    }

    public Tarjeta getTarjetaById(Integer id) {
        return tarjetaRepository.findById(id).get();
    }

    public Tarjeta saveTarjeta(Tarjeta tarjeta) {return tarjetaRepository.save(tarjeta);}
}
