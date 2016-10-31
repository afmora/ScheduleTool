package modelo;

public class FranjaHoraria {
    private int idFranjaHoraria;
    private short horaInicio;
    
    public FranjaHoraria(){
        
    }

    public int getIdFranjaHoraria() {
        return idFranjaHoraria;
    }

    public void setIdFranjaHoraria(int idFranjaHoraria) {
        this.idFranjaHoraria = idFranjaHoraria;
    }

    public short getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(short horaInicio) {
        this.horaInicio = horaInicio;
    }  
    
    public enum DiaSemana
    {
        Lunes,Martes,Miercoles,Jueves,Viernes
    }
    
}
