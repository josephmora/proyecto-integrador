package com.joseph.proyecto.integrador.modelo;

import javax.persistence.*;

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
//como sera mapeado en la otra clase
    @OneToOne(mappedBy="domicilio")
    private Paciente paciente;





    public int getId() {
        return id;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setId(int id) {
        this.id = id;
    }
}
