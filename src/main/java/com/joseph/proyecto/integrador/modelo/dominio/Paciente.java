package com.joseph.proyecto.integrador.modelo.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private LocalDate fechaIngreso;
    @OneToOne
    @JoinColumn(name= "domicilio_id", nullable = true)
    private Domicilio domicilio;


    @ManyToOne //muchos pacientes tienen un mismo odontologo
    @JoinColumn(name = "paciente_id", nullable = true)
    private Odontologo odontologo;

    @OneToMany(mappedBy="paciente")
    @JsonIgnore //evita el ciclo infinito de llamar una y otra vez un dato , ignora el dato turnos , siempre va en Muchos
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
