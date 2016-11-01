package mb;

import controlador.DaoUsuario;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

import modelo.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioMB {

    private DaoUsuario du;
    private Usuario u;
    private int id;
    private String nombre;
    private String apellido;
    private String alias;
    private String contrasenna;

    public UsuarioMB() throws SQLException, ClassNotFoundException {
        //dlg = new DaoLogin();
        u = new Usuario();
        alias = null;
        contrasenna =null;
        id = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }

    public void login() throws SQLException, ClassNotFoundException {
        du = new DaoUsuario();
        u.setAlias(alias);
        u.setContrasenna(contrasenna);
        FacesMessage msg = null;
        int j = du.leerRegistro(1);
        
        if(j == 1) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", alias);            
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error",
                    "Credenciales no válidas");            
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public String regresar(){
		return "vistaRegistroMateria";
    }
    public void registrar() throws SQLException, ClassNotFoundException {
        du = new DaoUsuario();
        u.setIdUsuario(id);
        u.setNombre(nombre);
        u.setApellido(apellido);
        u.setAlias(alias);
        u.setContrasenna(contrasenna);
        FacesMessage msg = null;
        int resultado = du.registrar(u);
        
        if(resultado == 1) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso: ", u.getAlias());            
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "El alias " + u.getAlias() + " ya existe", 
            "Vuelva a intentarlo");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }    

}
