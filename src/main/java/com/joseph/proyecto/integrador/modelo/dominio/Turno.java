package com.joseph.proyecto.integrador.modelo.dominio;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "turnos")

public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate fecha;

    @ManyToOne //muchos turnos tiene un paciente
    @JoinColumn(name ="paciente_id" , nullable = false)
    private Paciente paciente;
    @ManyToOne //muchos turnos tiene un odontologo
    @JoinColumn(name ="odontologo_id", nullable = false)
    private Odontologo odontologo;

    public Turno() {
    }

    public int getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setId(int id) {
        this.id = id;
    }
}
