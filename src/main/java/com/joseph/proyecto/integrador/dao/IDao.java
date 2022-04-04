package com.joseph.proyecto.integrador.dao;

import java.util.List;

public interface IDao <T>{
    List<T> listarElementos();
    T buscarPorId(int id);
    T buscarPorEmail(String email);
    T guardar(T elemento);
    T actualizar(T elemento);
    void eliminar(int id);

}
