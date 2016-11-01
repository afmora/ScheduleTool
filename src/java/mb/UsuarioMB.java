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
    private String usuario;
    private String contrasenna;

    public UsuarioMB() throws SQLException, ClassNotFoundException {
        //dlg = new DaoLogin();
        u = new Usuario();
        usuario = null;
        contrasenna =null;
        id = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
        u.setAlias(usuario);
        u.setContrasenna(contrasenna);
        FacesMessage msg = null;
        int j = du.leerRegistro(1);
        
        if(j == 1) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", usuario);            
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
        u.setAlias(usuario);
        u.setContrasenna(contrasenna);
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        int resultado = du.registrar(u);
        
        if(resultado == 1) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso: ", u.getAlias());
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario incorrecto",
                    "Ingrese un usuario válido");            
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
