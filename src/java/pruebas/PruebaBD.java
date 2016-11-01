package pruebas;

import controlador.DaoPrograma;
import controlador.DaoUsuario;
import java.sql.SQLException;

public class PruebaBD {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DaoUsuario du = new DaoUsuario();
        DaoPrograma dp = new DaoPrograma();
        
        dp.leerRegistro(2);
    
    }
    
}
