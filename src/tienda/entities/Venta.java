package tienda.entities;

import tienda.enums.Entrega;
import tienda.enums.Estado;
import java.sql.Date;

public class Venta {

    // Declarar variables
    private int id;
    private int id_cliente;
    private int id_usuario;
    private Date fecha_venta;
    private float importe;
    private Estado estado;
    private Entrega entrega;
    private String dir_entrega;

    //Constructores
    public Venta() {
    }

    public Venta(int id, int id_cliente, int id_usuario, Date fecha_venta, float importe, Estado estado, Entrega entrega, String dir_entrega) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.id_usuario = id_usuario;
        this.fecha_venta = fecha_venta;
        this.importe = importe;
        this.estado = estado;
        this.entrega = entrega;
        this.dir_entrega = dir_entrega;
    }

    public Venta(int id_cliente, int id_usuario, Date fecha_venta, float importe, Estado estado, Entrega entrega, String dir_entrega) {
        this.id_cliente = id_cliente;
        this.id_usuario = id_usuario;
        this.fecha_venta = fecha_venta;
        this.importe = importe;
        this.estado = estado;
        this.entrega = entrega;
        this.dir_entrega = dir_entrega;
    }

    public Venta(int id_cliente, int id_usuario, Date fecha_venta, float importe, Estado estado, Entrega entrega) {
        this.id_cliente = id_cliente;
        this.id_usuario = id_usuario;
        this.fecha_venta = fecha_venta;
        this.importe = importe;
        this.estado = estado;
        this.entrega = entrega;
    }

    public Venta(Estado estado, Entrega entrega, String dir_entrega) {
        this.estado = estado;
        this.entrega = entrega;
        this.dir_entrega = dir_entrega;
    }

    public Venta(int id_cliente, int id_usuario, float importe, Estado estado,
            Entrega entrega, String dir_entrega) {
        this.id_cliente = id_cliente;
        this.id_usuario = id_usuario;
        this.importe = importe;
        this.estado = estado;
        this.entrega = entrega;
        this.dir_entrega = dir_entrega;
    }

    // Sobreescribir toString
    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", id_cliente=" + id_cliente
                + ", id_usuario=" + id_usuario + ", fecha_venta=" + fecha_venta
                + ", importe=" + importe + ", estado=" + estado + ", entrega="
                + entrega + ", dir_entrega=" + dir_entrega + '}';
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public String getDir_entrega() {
        return dir_entrega;
    }

    public void setDir_entrega(String dir_entrega) {
        this.dir_entrega = dir_entrega;
    }

}
