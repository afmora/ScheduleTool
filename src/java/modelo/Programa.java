package modelo;

public class Programa {
    private int idPrograma;
    private String nombre;
    
    public Programa(){
        
    }

    public int getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(int idPrograma) {
        this.idPrograma = idPrograma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Id: " + idPrograma + ", Nombre: " + nombre;
    }
    
    
    
    
    
}
