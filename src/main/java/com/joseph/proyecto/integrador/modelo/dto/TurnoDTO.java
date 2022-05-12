package com.joseph.proyecto.integrador.modelo.dto;

import com.joseph.proyecto.integrador.modelo.dominio.Odontologo;
import com.joseph.proyecto.integrador.modelo.dominio.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
public class TurnoDTO {
    private LocalDate fecha;
    private PacienteDTO paciente;
    private OdontologoDTO odontologo;

}
