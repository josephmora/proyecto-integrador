package com.joseph.proyecto.integrador.dao;


import com.joseph.proyecto.integrador.modelo.Odontologo;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class OdontologoDAOH2 implements IDao<Odontologo> {

    private static Connection getConnection() throws  Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/integradora","root","");

    }

    @Override
    public List<Odontologo> listarElementos() {
        Connection connection = null;
        List<Odontologo> listaDeOdontologo = new ArrayList<>();
        Odontologo odontologo = null;

        try{
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM odontologo");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                odontologo = new Odontologo(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));

                //agrego el paciente encontrado a la lista de pacientes
                listaDeOdontologo.add(odontologo);

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
        return listaDeOdontologo;
    }

    @Override
    public Odontologo buscarPorId(int id) {
        Connection connection =null;
        Odontologo odontologo = null;

        try{
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM odontologo WHERE id= ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                odontologo = new Odontologo(rs.getInt(1), rs.getString(2),rs.getString(3),
                        rs.getString(4));
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
        return odontologo;
    }

    @Override
    //odontologo no tiene email por eso no se implementa la logica
    public Odontologo buscarPorEmail(String email) {
        return null;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        try {
            connection = getConnection();
            //obtengo la ultima id generado desde la vista y se lo seteo a odontologo
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO odontologo(nombre, apellido, matricula) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setString(3, odontologo.getMatricula());

            preparedStatement.executeUpdate();
            //el id se lo seteo a odontologo
            ResultSet claves= preparedStatement.getGeneratedKeys();
            while(claves.next()){
                odontologo.setId(claves.getInt(1));

            }
            preparedStatement.close();

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

        return odontologo;
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        Connection connection = null;
        try {
            connection = getConnection();
            //obtengo la ultima id generado desde la vista y se lo seteo a odontologo
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE odontologo SET nombre=?, apellido=?, matricula=? WHERE id=?");
            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setString(3, odontologo.getMatricula());
            preparedStatement.setInt(4, odontologo.getId());

            preparedStatement.executeUpdate();

            preparedStatement.close();

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

        return odontologo;
    }

    @Override
    public void eliminar(int id) {
        Connection connection = null;
        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM odontologo WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

            preparedStatement.close();

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

    }
}
