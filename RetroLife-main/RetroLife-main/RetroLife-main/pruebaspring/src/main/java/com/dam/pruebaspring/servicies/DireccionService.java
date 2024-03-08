package com.dam.pruebaspring.servicies;

import com.dam.pruebaspring.models.Direccion;
import com.dam.pruebaspring.repositories.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionService {
    @Autowired
    private DireccionRepository direccionRepository;

    public List<Direccion> getAllDirecciones() {
        return direccionRepository.findAll();
    }

    public Direccion getDireccionById(Integer id) {
        return direccionRepository.findById(id).get();
    }

    public Direccion saveDireccion(Direccion direccion) {
        return direccionRepository.save(direccion);
    }
}
