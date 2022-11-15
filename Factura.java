
package d11082022;

import Empleado.CuentasPorPagar;

public class Factura implements CuentasPorPagar {
    private int id;
    private String nombreProducto;
    private float precioProducto;
    private int cantidad;

    public Factura(int id, String nombreProducto, float precioProducto, int cantidad) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public float montoApagar(){
        return precioProducto * cantidad;
    }
    
    @Override
    public String toString() {
        return String.format("%-5d %-10s %-10.2f %-5d %-10.2f", id, nombreProducto, precioProducto, cantidad, montoApagar());
    
    }
    
    
    
}
