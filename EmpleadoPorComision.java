
package Empleado;

public class EmpleadoPorComision extends Empleado{

    protected float ventastotal;
    protected float tarifasporcomision;

    public EmpleadoPorComision(int id, String nombre, String apellido, float ventastotal, float tarifasporcomision) {
        super(id, nombre, apellido);
        this.ventastotal = ventastotal;
        this.tarifasporcomision = tarifasporcomision;
    }

    
    public float getVentastotal() {
        return ventastotal;
    }

    public void setVentastotal(float ventastotal) {
        this.ventastotal = ventastotal;
    }

    public float getTarifasporcomision() {
        return tarifasporcomision;
    }

    public void setTarifasporcomision(float tarifasporcomision) {
        this.tarifasporcomision = tarifasporcomision;
    }
    
    @Override
    public String toString(){
        return String.format("%s %-10.2f %-10.2f %-10.2f ",super.toString(), ventastotal,tarifasporcomision, montoApagar());
    }

    @Override
    public float montoApagar() {
       return ventastotal * tarifasporcomision / 100;
    }
}
