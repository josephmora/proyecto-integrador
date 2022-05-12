package com.joseph.proyecto.integrador.exceptions;

public class BadRequestException extends Exception{
    public BadRequestException(String mensaje){
        super(mensaje);
    }
}
