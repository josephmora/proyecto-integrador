package com.joseph.proyecto.integrador.repository;

import com.joseph.proyecto.integrador.modelo.dominio.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDomicilioRepositoy extends JpaRepository<Domicilio, Integer> {
}
