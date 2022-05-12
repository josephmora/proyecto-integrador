package com.joseph.proyecto.integrador.modelo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class PacienteDTO {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private LocalDate fechaIngreso;
    private DomicilioDTO domicilio;//probar con domicilio DTO


}
