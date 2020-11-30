package tienda.entities;

public class Detalle_ventas {

    // Declarar variables
    private int id;
    private int id_producto;
    private int id_venta;

    // Constructores
    public Detalle_ventas() {
    }

    public Detalle_ventas(int id_producto, int id_venta) {
        this.id_producto = id_producto;
        this.id_venta = id_venta;
    }

    public Detalle_ventas(int id, int id_producto, int id_venta) {
        this.id = id;
        this.id_producto = id_producto;
        this.id_venta = id_venta;
    }

    // Sobreescribir toString
    @Override
    public String toString() {
        return "Detalle_ventas{" + "id=" + id + ", id_producto=" + id_producto + ", id_venta=" + id_venta + '}';
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

}
