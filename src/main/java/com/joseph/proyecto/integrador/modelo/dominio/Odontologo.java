package com.joseph.proyecto.integrador.modelo.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private String matricula;


    @OneToMany(mappedBy= "odontologo")
    @JsonIgnore
    private Set<Paciente> pacientes;

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
