package com.joseph.proyecto.integrador.repository;

import com.joseph.proyecto.integrador.modelo.dominio.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
    /*@Query("select email from Paciente where email = ?4")
    Paciente buscarPacienteConEmail(String name);*/
}
