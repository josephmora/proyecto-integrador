package com.joseph.proyecto.integrador.service;

import com.joseph.proyecto.integrador.modelo.dto.DomicilioDTO;

public interface IDomicilioService {
    void crearDomicilio(DomicilioDTO domicilioDTO);
    DomicilioDTO leerUnDomicilio(int id);
    void actualizarDomicilio(DomicilioDTO domicilioDTO);
    void eliminarDomicilio(int id);

}
