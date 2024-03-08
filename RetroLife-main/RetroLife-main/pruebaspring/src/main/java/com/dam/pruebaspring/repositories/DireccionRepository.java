package com.dam.pruebaspring.repositories;

import com.dam.pruebaspring.models.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Integer> {

}