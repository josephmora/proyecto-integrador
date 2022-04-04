package com.joseph.proyecto.integrador.service;

import com.joseph.proyecto.integrador.dao.IDao;
import com.joseph.proyecto.integrador.dominio.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PacienteService  {

    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    // trabajar con el DAO y maneja los datos de la BD H2

    public List<Paciente> listaPacientes() {
        return pacienteIDao.listarElementos();
    }


    public Paciente buscarPorEmail(String email) {
        return pacienteIDao.buscarPorEmail(email);
    }

    public Paciente guardar(Paciente paciente){
        return pacienteIDao.guardar(paciente);

    }
    public Paciente actualizar(Paciente paciente){
        return pacienteIDao.actualizar(paciente);

    }
    public Paciente buscarPorId(int id){
        return pacienteIDao.buscarPorId(id);
    }

    public void eliminarPaciente(int id){
        pacienteIDao.eliminar(id);
    }


}
