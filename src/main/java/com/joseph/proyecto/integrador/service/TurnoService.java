package com.joseph.proyecto.integrador.service;

import com.joseph.proyecto.integrador.dao.IDao;
import com.joseph.proyecto.integrador.dominio.Turno;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TurnoService {
    private IDao<Turno> turnoIDao;

    public TurnoService(IDao<Turno> turnoIDao){
        this.turnoIDao = turnoIDao;
    }
    public Turno registrarTurno(Turno turno){
        return turnoIDao.guardar(turno);

    }
    public List<Turno> listarTurnos(){
        return turnoIDao.listarElementos();
    }
}
