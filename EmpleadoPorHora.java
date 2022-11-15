
package Empleado;

public class EmpleadoPorHora extends Empleado{
    
    private int ht;
    private float pg;

    public EmpleadoPorHora(int id, String nombre, String apellido, int ht, float pg) {
        super(id, nombre, apellido);
        this.ht = ht;
        this.pg = pg;
    }

    public int getHt() {
        return ht;
    }

    public void setHt(int ht) {
        this.ht = ht;
    }

    public float getPg() {
        return pg;
    }

    public void setPg(float pg) {
        this.pg = pg;
    }
    
    public float montoApagar(){
        return ht * pg;
    }
     @Override
    public String toString(){
        return String.format("%s %-5d %-10.2f %-10.2f",super.toString(), ht, pg, montoApagar());
    }
    
}
