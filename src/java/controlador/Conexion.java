package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection cx;
    private static boolean estado;

    public Conexion() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        cx= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Pruebas","postgres","12345");
    }
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (cx==null){
            new Conexion();
        }
        estado = true;
        return cx;
    }
    
    public static void cierraConexiones() throws SQLException {
        estado = cx.createStatement().execute("select pg_terminate_backend(pid) from pg_stat_activity where pid<> pg_backend_pid() and datname ='postgres'");        
    }
    
    public static boolean estadoConexion() throws SQLException {
        if (cx==null){
            return estado;
        }else
            estado = true;                    
        return estado;
    }

}
