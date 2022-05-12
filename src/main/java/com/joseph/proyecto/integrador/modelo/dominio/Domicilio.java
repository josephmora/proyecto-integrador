package com.joseph.proyecto.integrador.modelo.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name= "Domicilio")
public class Domicilio {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name = "calle")
    private String calle;
    @Column(name = "numero")
    private int numero;
    @Column(name = "localidad")
    private String localidad;
    @Column(name = "provincia")
    private String provincia;
//aqui se coloca "domicilio" como sera mapeado en la clase paciente, es decir como se llamo al atributo del otro lado
    //@OneToOne(mappedBy="domicilio") //un domicilio tien un paciente
    //private Paciente paciente;  //no es necesario si es una relacion unidireccional , tampoco iria un controller de domicilio


    public Domicilio() {
    }



}
