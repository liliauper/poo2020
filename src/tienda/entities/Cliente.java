package tienda.entities;

public class Cliente {

    // declaracion variables
    private int id;
    private String nombre;
    private String apellido;
    private String dni_cuit;
    private String pais;
    private String provincia;
    private String direccion;

    private String telefono;
    private String mail;
    private String fechaNacimiento;

    private String contrasenia;

    // Constructores
    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String dni_cuit, String pais, String provincia, String direccion, String telefono, String mail, String fechaNacimiento, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni_cuit = dni_cuit;
        this.pais = pais;
        this.provincia = provincia;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasenia = contrasenia;
    }

    public Cliente(int id, String nombre, String apellido, String dni_cuit, String pais, String provincia, String direccion, String telefono, String mail, String fechaNacimiento, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni_cuit = dni_cuit;
        this.pais = pais;
        this.provincia = provincia;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasenia = contrasenia;
    }

    // Sobreescribir metodo toString
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni_cuit=" + dni_cuit + ", pais=" + pais + ", provincia=" + provincia + ", direccion=" + direccion + ", telefono=" + telefono + ", mail=" + mail + ", fechaNacimiento=" + fechaNacimiento + ", contrasenia=" + contrasenia + '}';
    }

// Gettes y Setters
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

    public String getDni_cuit() {
        return dni_cuit;
    }

    public void setDni_cuit(String dni_cuit) {
        this.dni_cuit = dni_cuit;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

}
