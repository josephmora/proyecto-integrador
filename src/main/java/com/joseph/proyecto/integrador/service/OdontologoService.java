package com.joseph.proyecto.integrador.service;

import com.joseph.proyecto.integrador.dao.IDao;
import com.joseph.proyecto.integrador.dominio.Odontologo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public List<Odontologo> listaOdontologos() {
        return odontologoIDao.listarElementos();

    }
    public Odontologo buscarPorId(int id){
        return odontologoIDao.buscarPorId(id);
    }
}
