package com.joseph.proyecto.integrador.modelo;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="Paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private LocalDate fechaIngreso;
    @OneToMany
    @JoinColumn(name= "domicilio_id", nullable = false)
    private Domicilio domicilio;


    @OneToOne(mappedBy="paciente")
    private Odontologo odontologo;

    @OneToMany(mappedBy="paciente")
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

    public String getEmail() {
        return email;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setId(int id) {
        this.id = id;
    }
}
