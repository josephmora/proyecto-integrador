package com.joseph.proyecto.integrador.modelo;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="Odontologo")
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private String matricula;


    @OneToMany
    @JoinColumn(name="paciente_id",nullable = false)
    private Paciente paciente;

    @OneToMany(mappedBy="odontologo")
    private Set<Turno> turnos;



    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setId(int id) {
        this.id = id;
    }
}
