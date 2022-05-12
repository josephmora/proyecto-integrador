package com.joseph.proyecto.integrador.service;

import com.joseph.proyecto.integrador.exceptions.BadRequestException;
import com.joseph.proyecto.integrador.modelo.dto.TurnoDTO;

import java.util.Set;

public interface ITurnoService {
    void crearTurno(TurnoDTO turnoDTO) throws BadRequestException;
    TurnoDTO leerUnTurno(int id);
    void actualizarTurno(TurnoDTO turnoDTO);
    void eliminarTurno(int id) throws BadRequestException;
    Set<TurnoDTO> listarTodosTurnos();

}
