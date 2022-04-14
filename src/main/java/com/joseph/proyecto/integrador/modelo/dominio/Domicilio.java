package com.joseph.proyecto.integrador.modelo.dominio;

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
//aqui se coloca "domicilio" como sera mapeado en la clase paciente, es decir como se llamo al atributo del otro lado
    @OneToOne(mappedBy="domicilio") //un domicilio tien un paciente
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
