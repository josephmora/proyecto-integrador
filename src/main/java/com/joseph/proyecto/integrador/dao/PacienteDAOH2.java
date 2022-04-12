package com.joseph.proyecto.integrador.dao;

import com.joseph.proyecto.integrador.modelo.Domicilio;
import com.joseph.proyecto.integrador.modelo.Odontologo;
import com.joseph.proyecto.integrador.modelo.Paciente;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository //para que spring la tenga en cuenta como parte importante
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
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM paciente");
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

        Connection connection = null;
        Paciente paciente= null;
        Domicilio domicilio = null;
        Odontologo odontologo = null;


        try{
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
            OdontologoDAOH2 odontologoDAOH2 = new OdontologoDAOH2();
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM paciente WHERE id = ?");
            preparedStatement.setInt(1, id);
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
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM paciente WHERE email LIKE ?");
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

    @Override
    public Paciente guardar(Paciente paciente) {

        Connection connection = null;
        try {
        connection = getConnection();
        DomicilioDAOH2 domicilioDAOH2= new DomicilioDAOH2();
        OdontologoDAOH2 odontologoDAOH2 = new OdontologoDAOH2();
        Domicilio domicilio = domicilioDAOH2.guardar(paciente.getDomicilio()); //guardo el domicilio que obtengo de un paciente
        Odontologo odontologo = odontologoDAOH2.guardar(paciente.getOdontologo());
        paciente.getDomicilio().setId(domicilio.getId()); //duda , segun se hacer porque el que se retorna es paciente
        paciente.getOdontologo().setId(odontologo.getId()); //seteo el id odontologo obtenido desde paciente
        PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO paciente(nombre, apellido, email, dni, fecha_ingreso, domicilio_id, odontologo_id) " +
                            "VALUES (?, ?, ?, ?, ? ,?,? )", Statement.RETURN_GENERATED_KEYS); //retorno el id de paciente
        preparedStatement.setString(1, paciente.getNombre());
        preparedStatement.setString(2, paciente.getApellido());
        preparedStatement.setString(3, paciente.getEmail());
        preparedStatement.setString(4, paciente.getDni());
        preparedStatement.setDate(5, Date.valueOf(paciente.getFechaIngreso()));
        preparedStatement.setInt(6, paciente.getDomicilio().getId());
        preparedStatement.setInt(7, paciente.getOdontologo().getId());

        preparedStatement.executeUpdate();
        //obtengo el id generado en la vista del paciente y se lo seteo
        ResultSet claves = preparedStatement.getGeneratedKeys();
        while(claves.next()){
            paciente.setId(claves.getInt(1)); //seteo el id que viene de la BD

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

        return paciente;
    }

    @Override
    public Paciente actualizar(Paciente paciente) {
        Connection connection = null;
        try {
            connection = getConnection();
            DomicilioDAOH2 domicilioDAOH2= new DomicilioDAOH2();
            OdontologoDAOH2 odontologoDAOH2 = new OdontologoDAOH2();
            Domicilio domicilio = domicilioDAOH2.actualizar(paciente.getDomicilio()); //actualizo el domicilio que obtengo de un paciente
            Odontologo odontologo = odontologoDAOH2.actualizar(paciente.getOdontologo());

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE paciente SET nombre=?, apellido=?, email=?, dni=?, fecha_ingreso=?, domicilio_id=?, odontologo_id=? " +
                            "WHERE id=?");
            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3, paciente.getEmail());
            preparedStatement.setString(4, paciente.getDni());
            preparedStatement.setDate(5, Date.valueOf(paciente.getFechaIngreso()));
            preparedStatement.setInt(6, paciente.getDomicilio().getId());
            preparedStatement.setInt(7, paciente.getOdontologo().getId());
            preparedStatement.setInt(8, paciente.getId()); //Seteo el id en el where a actualizar

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

        return paciente;
    }

    @Override
    public void eliminar(int id) {
        Connection connection = null;
        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM paciente WHERE id=?");

            preparedStatement.setInt(1, id); //

            preparedStatement.executeUpdate();

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
