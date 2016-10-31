package modelo;

public class Prerrequisito {
    private int idPrerrequisito;
    private int idMateria;
    private int idMateriaPrerrequisito;

    public Prerrequisito(int idPrerrequisito) {
        this.idPrerrequisito = idPrerrequisito;
    }
    
    public int getIdPrerrequisito() {
        return idPrerrequisito;
    }

    public void setIdPrerrequisito(int idPrerrequisito) {
        this.idPrerrequisito = idPrerrequisito;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public int getIdMateriaPrerrequisito() {
        return idMateriaPrerrequisito;
    }

    public void setIdMateriaPrerrequisito(int idMateriaPrerrequisito) {
        this.idMateriaPrerrequisito = idMateriaPrerrequisito;
    }
}
