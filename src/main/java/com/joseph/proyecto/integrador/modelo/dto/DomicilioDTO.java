package com.joseph.proyecto.integrador.modelo.dto;


import com.joseph.proyecto.integrador.modelo.dominio.Paciente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomicilioDTO {
    private String calle;
    private int numero;
    private String localidad;
    private String provincia;
    //private Paciente paciente;

}
