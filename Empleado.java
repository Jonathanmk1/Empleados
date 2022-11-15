package Empleado;

public abstract class Empleado extends Object implements CuentasPorPagar {

    protected int id;
    protected String nombre;
    protected String apellido;

    public Empleado(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
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

    @Override
    public String toString() {
        return String.format("%-5d %-30s %-30s", id, nombre, apellido);
    }
}
