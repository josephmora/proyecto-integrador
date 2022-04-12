package com.joseph.proyecto.integrador.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joseph.proyecto.integrador.modelo.Odontologo;
import com.joseph.proyecto.integrador.modelo.OdontologoDTO;
import com.joseph.proyecto.integrador.repository.IOdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService {
    @Autowired
    IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapeo;

    private void guardarOdontologo(OdontologoDTO odontologoDTO){
        Odontologo odontologo = mapeo.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }


    @Override
    public void crearOdontologo(OdontologoDTO odontologoDTO) {
        guardarOdontologo(odontologoDTO);

    }

    @Override
    public OdontologoDTO leerUnOdontologo(int id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if (odontologo.isPresent()){
            odontologoDTO= mapeo.convertValue(odontologo, OdontologoDTO.class);
        }

        return odontologoDTO;
    }

    @Override
    public void actualizarUnOdontologo(OdontologoDTO odontologoDTO) {
        guardarOdontologo(odontologoDTO);

    }

    @Override
    public void elimiarUnOdontologo(int id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public Set<OdontologoDTO> listarTodosOdontologos() {
        //creo una lista para almacenar los odontologos
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO= new HashSet<>();
        //recorro cada odontologo y lo convierto a DTO
        for(Odontologo odontologo: odontologos){
            odontologosDTO.add(mapeo.convertValue(odontologo, OdontologoDTO.class));

        }
        return odontologosDTO;
    }
}
