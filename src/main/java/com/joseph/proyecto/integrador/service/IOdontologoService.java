package com.joseph.proyecto.integrador.service;

import com.joseph.proyecto.integrador.modelo.dto.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {
    void crearOdontologo(OdontologoDTO odontologoDTO);
    OdontologoDTO leerUnOdontologo(int id);
    void actualizarUnOdontologo(OdontologoDTO odontologoDTO);
    void elimiarUnOdontologo(int id);
    Set<OdontologoDTO> listarTodosOdontologos();
}
