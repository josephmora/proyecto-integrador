package com.joseph.proyecto.integrador.dao;

import com.joseph.proyecto.integrador.dominio.Domicilio;
import com.joseph.proyecto.integrador.dominio.Odontologo;
import com.joseph.proyecto.integrador.dominio.Paciente;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component //para que spring la tenga en cuenta como parte importante (Genera duda)
public class PacienteDAOH2 implements IDao<Paciente>{

    private static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/integradora","root","");

    }
    @Override
    public List<Paciente> listarElementos() {
        Connection connection = null;
        List<Paciente> listaDePacientes = new ArrayList<>();
        Paciente paciente= null;
        Domicilio domicilio = null;
        Odontologo odontologo= null;

        try{
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
            OdontologoDAOH2 odontologoDAOH2 = new OdontologoDAOH2();

            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pacientes");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int id_domicilio = rs.getInt(7); // me quedo la duda
                int id_odontologo = rs.getInt(8);
                domicilio= domicilioDAOH2.buscarPorId(id_domicilio);
                odontologo= odontologoDAOH2.buscarPorId(id_odontologo);
                paciente = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3),
                                        rs.getString(4),rs.getString(5),rs.getDate(6).toLocalDate(), domicilio, odontologo );

                //agrego el paciente encontrado a la lista de pacientes
                listaDePacientes.add(paciente);

            }



        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        return listaDePacientes;
    }

    @Override
    public Paciente buscarPorId(int id) {

        return null;
    }

    @Override
    public Paciente buscarPorEmail(String email) {
        Connection connection = null;
        Paciente paciente= null;
        Domicilio domicilio = null;
        Odontologo odontologo = null;


        try{
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
            OdontologoDAOH2 odontologoDAOH2 = new OdontologoDAOH2();
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pacientes WHERE email LIKE ?");
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                //si encuentro el correo obtendo el id
                int id_domicilio = rs.getInt(7);
                int id_odontologo = rs.getInt(8);

                //uso el dao de domicilio para buscar todos los datos de domicilio
                domicilio= domicilioDAOH2.buscarPorId(id_domicilio);
                odontologo= odontologoDAOH2.buscarPorId(id_odontologo);
                paciente = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getDate(6).toLocalDate(), domicilio, odontologo);

            }



        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        return paciente;
    }
}
