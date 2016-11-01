package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Programa;

public class DaoPrograma {
    private PreparedStatement preparedStatement;
    private Connection connection;
    public DaoPrograma() throws SQLException, ClassNotFoundException {
        connection=Conexion.getConnection();
    }

    public int guardar(Programa programa) throws SQLException {
        preparedStatement=null;
        int resultado=0;
        preparedStatement=connection.prepareStatement("INSERT  INTO  programa(nombre) VALUES (?)");
        preparedStatement.setString(1,programa.getNombre());
        resultado=preparedStatement.executeUpdate();
        preparedStatement.close();
        return resultado;        
    }

    public int eliminar(Programa programa) throws SQLException {
        preparedStatement=null;
        int resultado=0;
        preparedStatement=connection.prepareStatement("DELETE FROM programa WHERE idprograma=?");
        preparedStatement.setInt(1,programa.getIdPrograma());
        resultado=preparedStatement.executeUpdate();
        return resultado;
    }

    public int editar(Programa programa) throws SQLException {
        preparedStatement=null;
        int resultado=0;
        preparedStatement=connection.prepareStatement("UPDATE programa set nombre=? where idprograma=?");
        preparedStatement.setString(1,programa.getNombre());
        resultado=preparedStatement.executeUpdate();
        preparedStatement.close();
        return  resultado;

    }
    public int leerRegistro(int id) throws SQLException{
        Programa programa=null;
        int resultado = 0;
        preparedStatement=null;
        ResultSet resultSet=null;
        preparedStatement= connection.prepareStatement("SELECT * FROM programa where idprograma=?");
        preparedStatement.setInt(1, id);
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            programa= new Programa();
            programa.setIdPrograma(resultSet.getInt("idprograma"));
            programa.setNombre(resultSet.getString("nombre"));
            System.out.println(programa.toString());
            resultado = 1;
        }
        resultSet.close();
        preparedStatement.close();
        return resultado;
    }
    
    public ArrayList<Programa> leerTodos() throws SQLException {
        preparedStatement=null;
        ResultSet resultSet=null;
        ArrayList<Programa> libroArrayList=new ArrayList<Programa>();
        Programa programa=null;
        preparedStatement= connection.prepareStatement("SELECT * FROM programa");
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            programa= new Programa();
            programa.setIdPrograma(resultSet.getInt("idprograma"));
            programa.setNombre(resultSet.getString("nombre"));
            libroArrayList.add(programa);
        }
        resultSet.close();
        preparedStatement.close();
        return libroArrayList;

    }
    
}
