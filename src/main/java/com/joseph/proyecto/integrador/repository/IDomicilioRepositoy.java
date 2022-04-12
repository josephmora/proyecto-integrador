package com.joseph.proyecto.integrador.repository;

import com.joseph.proyecto.integrador.modelo.Domicilio;
import com.joseph.proyecto.integrador.modelo.DomicilioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDomicilioRepositoy extends JpaRepository<Domicilio, Integer> {
}
