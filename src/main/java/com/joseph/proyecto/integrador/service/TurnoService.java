package com.joseph.proyecto.integrador.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joseph.proyecto.integrador.modelo.dominio.Turno;
import com.joseph.proyecto.integrador.modelo.dto.TurnoDTO;
import com.joseph.proyecto.integrador.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService{
    @Autowired
    ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapeo;

    private void guardarTurno(TurnoDTO turnoDTO){
        Turno turno = mapeo.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
    }

    @Override
    public void crearTurno(TurnoDTO turnoDTO) {
        guardarTurno(turnoDTO);
    }

    @Override
    public TurnoDTO leerUnTurno(int id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if(turno.isPresent()){
            turnoDTO = mapeo.convertValue(turno, TurnoDTO.class);
        }
        return turnoDTO;
    }

    @Override
    public void actualizarTurno(TurnoDTO turnoDTO) {
        guardarTurno(turnoDTO);
    }

    @Override
    public void eliminarTurno(int id) {
        turnoRepository.deleteById(id);

    }

    @Override
    public Set<TurnoDTO> listarTodosTurnos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();
        for (Turno turno: turnos){
            turnosDTO.add(mapeo.convertValue(turno, TurnoDTO.class));
        }
        return turnosDTO;
    }
}
