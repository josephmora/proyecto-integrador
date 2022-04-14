package com.joseph.proyecto.integrador.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joseph.proyecto.integrador.modelo.dominio.Paciente;
import com.joseph.proyecto.integrador.modelo.dto.PacienteDTO;
import com.joseph.proyecto.integrador.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService{
    @Autowired
    IPacienteRepository pacienteRepository;
    @Autowired
    ObjectMapper mapeo;

    private void guardarPaciente(PacienteDTO pacienteDTO){
        Paciente paciente = mapeo.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);

    }


    @Override
    public void crearPaciente(PacienteDTO pacienteDTO) {
        guardarPaciente(pacienteDTO);
    }

    @Override
    public PacienteDTO leerUnPacientePorId(int id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if(paciente.isPresent()){
            pacienteDTO= mapeo.convertValue(paciente,PacienteDTO.class);
        }

        return pacienteDTO;
    }

    @Override
    public PacienteDTO leerUnPacientePorEmail(String email) {
        //llamo al metodo con HQL que defini en el repository de paciente para encontrar por email
    /*    Paciente paciente = pacienteRepository.buscarPacienteConEmail(email);
        PacienteDTO pacienteDTO = null;
        if(paciente != null){
            pacienteDTO= mapeo.convertValue(paciente,PacienteDTO.class);
        }

        return pacienteDTO;*/
        return null;

    }

    @Override
    public void actualizarUnPaciente(PacienteDTO pacienteDTO) {
        guardarPaciente(pacienteDTO);

    }

    @Override
    public void eliminarPaciente(int id) {
        pacienteRepository.deleteById(id);

    }

    @Override
    public Set<PacienteDTO> ListarTodosPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();

        for(Paciente paciente: pacientes){
            pacientesDTO.add(mapeo.convertValue(paciente, PacienteDTO.class));
        }
        return pacientesDTO;

    }
}
