package tienda.entities;

import tienda.enums.Disponible;

public class Producto {

    // Declaracion variables
    private int id;
    private int cod_productos;
    private String nombre;
    private float precio;
    private int cantidad;
    private String imagen;
    private String descripcion;
    private String detalles;
    private Disponible disponible;
    private int visitas;
    private int ventas;

    // Constructores
    public Producto() {
    }

    public Producto(int cod_productos, String nombre, float precio, int cantidad, String imagen, String descripcion, String detalles, Disponible disponible) {
        this.cod_productos = cod_productos;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.detalles = detalles;
        this.disponible = disponible;
    }

    public Producto(int cod_productos, String nombre, float precio, int cantidad, String imagen, Disponible disponible) {
        this.cod_productos = cod_productos;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.imagen = imagen;
        this.disponible = disponible;
    }

    public Producto(int cod_productos, String nombre, float precio, int cantidad, String imagen, String descripcion, String detalles, Disponible disponible, int visitas, int ventas) {
        this.cod_productos = cod_productos;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.detalles = detalles;
        this.disponible = disponible;
        this.visitas = visitas;
        this.ventas = ventas;
    }

    public Producto(int id, int cod_productos, String nombre, float precio, int cantidad, String imagen, String descripcion, String detalles, Disponible disponible, int visitas, int ventas) {
        this.id = id;
        this.cod_productos = cod_productos;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.detalles = detalles;
        this.disponible = disponible;
        this.visitas = visitas;
        this.ventas = ventas;
    }

    // Sobreescribir toString
    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", cod_productos=" + cod_productos + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + ", imagen=" + imagen + ", descripcion=" + descripcion + ", detalles=" + detalles + ", disponible=" + disponible + ", visitas=" + visitas + ", ventas=" + ventas + '}';
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod_productos() {
        return cod_productos;
    }

    public void setCod_productos(int cod_productos) {
        this.cod_productos = cod_productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Disponible getDisponible() {
        return disponible;
    }

    public void setDisponible(Disponible disponible) {
        this.disponible = disponible;
    }

    public int getVisitas() {
        return visitas;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

}
