package com.joseph.proyecto.integrador.modelo.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
@Getter
@Setter
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "domicilio_id", nullable = false)//cambiar a false
    private Domicilio domicilio;


    @ManyToOne //muchos pacientes tienen un mismo odontologo
    @JoinColumn(name = "odontologo_id", nullable = true)
    private Odontologo odontologo;

    @OneToMany(mappedBy="paciente")
    @JsonIgnore //evita el ciclo infinito de llamar una y otra vez un dato , ignora el dato turnos , siempre va en Muchos
    private Set<Turno> turnos;


    public Paciente() {
    }


}
