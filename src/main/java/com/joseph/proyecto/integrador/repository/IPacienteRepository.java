package com.joseph.proyecto.integrador.repository;

import com.joseph.proyecto.integrador.modelo.dominio.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
    @Query("select p from Paciente p where p.email = ?1") // ?1 es la posicion del parametro de abajo
    Paciente buscarPacienteConEmail(String email);
}
