package com.joseph.proyecto.integrador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class ProyectoIntegradorApplication {

	private static void cargarBD(){
		Connection connection = null;
		try {
			Class.forName("org.h2.Driver").newInstance();
			//aqui es donde se ejecuta solo init para cargar los datos
			connection = DriverManager.getConnection("jdbc:h2:~/integradora;INIT=RUNSCRIPT FROM 'create.sql'","root","");

		} catch (Exception e) {
			e.printStackTrace();
		}
		  finally{
			  try {
				  connection.close();
			  }
			  catch (SQLException e) {
				  e.printStackTrace();
			  }
			}



	}

	public static void main(String[] args) {
		cargarBD();
		SpringApplication.run(ProyectoIntegradorApplication.class, args); //ejecuta la aplicación
	}

}
