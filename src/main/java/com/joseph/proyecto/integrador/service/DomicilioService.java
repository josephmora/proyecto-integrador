package com.joseph.proyecto.integrador.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joseph.proyecto.integrador.modelo.dominio.Domicilio;
import com.joseph.proyecto.integrador.modelo.dto.DomicilioDTO;
import com.joseph.proyecto.integrador.repository.IDomicilioRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class DomicilioService implements IDomicilioService {

    //Instancio al repository para usar los metodos CRUD
    @Autowired
    IDomicilioRepositoy domicilioRepository;
    //instancio un objeto que permita mapear de DTO a Class y viceversa
    @Autowired
    ObjectMapper mapeo;
    //Creo un metodo privado guardar para ser reutilizado en actualizar y eliminar y crear
    private void guardarDomicilio(DomicilioDTO domicilioDTO){
        //convierto DTO a Class
        Domicilio domicilio = mapeo.convertValue(domicilioDTO, Domicilio.class);
        //guardo la entidad en DB
        domicilioRepository.save(domicilio);
    }
    @Override
    public void crearDomicilio(DomicilioDTO domicilioDTO) {
        guardarDomicilio(domicilioDTO);

    }

    @Override
    public DomicilioDTO leerUnDomicilio(int id) {
        /*Un objeto contenedor que puede contener o no un valor no nulo. Si hay un valor presente, isPresent() devuelve verdadero. Si no hay ningún valor presente, el objeto se considera vacío y isPresent() devuelve falso.*/
        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        DomicilioDTO domicilioDTO= null;
        //convierto de entidad a DTO
        if(domicilio.isPresent()) { //devuelve un booleano
            domicilioDTO = mapeo.convertValue(domicilio, DomicilioDTO.class);
        }
        return domicilioDTO;
    }

    @Override
    public void actualizarDomicilio(DomicilioDTO domicilioDTO) {
        guardarDomicilio(domicilioDTO);


    }

    @Override
    public void eliminarDomicilio(int id) {
        domicilioRepository.deleteById(id);

    }
}
