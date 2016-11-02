package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Usuario;

public class DaoUsuario{
    private PreparedStatement preparedStatement;
    private Connection connection;
    public DaoUsuario() throws SQLException, ClassNotFoundException {
        connection=Conexion.getConnection();
    }

    public int guardar(Usuario usuario) throws SQLException {
        preparedStatement=null;
        int resultado=0;
        
        preparedStatement=connection.prepareStatement("INSERT  INTO  usuario(nombres,apellidos,alias,contrasenna) VALUES (?,?,?,?)");
        preparedStatement.setString(1,usuario.getNombre());
        preparedStatement.setString(2,usuario.getApellido());
        preparedStatement.setString(3,usuario.getAlias());
        preparedStatement.setString(4,usuario.getContrasenna());
        resultado=preparedStatement.executeUpdate();
        preparedStatement.close();
        return resultado;        
    }
    public int registrar(Usuario usuario) throws SQLException {
        ResultSet resultSet=null;
        preparedStatement=null;
        int resultado=1;
        preparedStatement= connection.prepareStatement("SELECT * FROM usuario where alias=?");
        preparedStatement.setString(1, usuario.getAlias());
        resultSet=preparedStatement.executeQuery();
        if(resultSet.next()){
            resultado=0;
        }else{
            preparedStatement=connection.prepareStatement("INSERT INTO usuario(nombres,apellidos,alias,contrasenna) VALUES (?,?,?,?)");
            preparedStatement.setString(1,usuario.getNombre().toUpperCase());
            preparedStatement.setString(2,usuario.getApellido().toUpperCase());
            preparedStatement.setString(3,usuario.getAlias());
            preparedStatement.setString(4,usuario.getContrasenna());
            resultado=preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        
        return resultado;        
    }

    public int eliminar(Usuario usuario) throws SQLException {
        preparedStatement=null;
        int resultado=0;
        preparedStatement=connection.prepareStatement("DELETE FROM usuario WHERE idusuario=?");
        preparedStatement.setInt(1,usuario.getIdUsuario());
        resultado=preparedStatement.executeUpdate();
        return resultado;
    }

    public int editar(Usuario usuario) throws SQLException {
        preparedStatement=null;
        int resultado=0;
        preparedStatement=connection.prepareStatement("UPDATE usuario set nombres=?,apellidos=?,alias=?,contrasenna=? where idusuario=?");
        preparedStatement.setString(1,usuario.getNombre());
        preparedStatement.setString(2,usuario.getApellido());
        preparedStatement.setString(3,usuario.getAlias());
        preparedStatement.setString(4,usuario.getContrasenna());
        resultado=preparedStatement.executeUpdate();
        preparedStatement.close();
        return  resultado;

    }
    public int leerRegistro(Usuario u) throws SQLException{
        Usuario usuario=null;
        int resultado = 0;
        preparedStatement=null;
        ResultSet resultSet=null;
        preparedStatement= connection.prepareStatement("SELECT * FROM usuario where alias=?,contrasenna=?");
        preparedStatement.setString(1, u.getAlias());
        preparedStatement.setString(2, u.getContrasenna());
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            usuario= new Usuario();
            usuario.setIdUsuario(resultSet.getInt("idusuario"));
            usuario.setNombre(resultSet.getString("nombres"));
            usuario.setApellido(resultSet.getString("apellidos"));
            usuario.setAlias(resultSet.getString("alias"));
            usuario.setContrasenna(resultSet.getString("contrasenna"));
            System.out.println(usuario.toString());
            resultado = 1;
        }                
        resultSet.close();
        preparedStatement.close();
        return resultado;
    }
    
    public int loguearse(Usuario u) throws SQLException{
        int resultado = 0;
        preparedStatement=null;
        ResultSet resultSet=null;
        preparedStatement= connection.prepareStatement("SELECT * FROM usuario where alias=?,contrasenna=?");
        preparedStatement.setString(1, u.getAlias());
        preparedStatement.setString(2, u.getContrasenna());
        resultSet=preparedStatement.executeQuery();
        if(resultSet.next()){
            resultado = 1;
        }
        resultSet.close();
        preparedStatement.close();
        return resultado;
    }
    
    public ArrayList<Usuario> leerTodos() throws SQLException {
        preparedStatement=null;
        ResultSet resultSet=null;
        ArrayList<Usuario> usuarioArrayList=new ArrayList<Usuario>();
        Usuario usuario=null;
        preparedStatement= connection.prepareStatement("SELECT * FROM programa");
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            usuario= new Usuario();
            usuario.setIdUsuario(resultSet.getInt("idusuario"));
            usuario.setNombre(resultSet.getString("nombre"));
            usuario.setApellido(resultSet.getString("apellido"));
            usuario.setAlias(resultSet.getString("alias"));
            usuario.setContrasenna(resultSet.getString("contrasenna"));
            usuarioArrayList.add(usuario);
        }
        resultSet.close();
        preparedStatement.close();
        return usuarioArrayList;

    }
    
}
