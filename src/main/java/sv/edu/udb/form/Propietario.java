package sv.edu.udb.form;

public class Propietario {
    private int id_Propietario;
    private String primer_Nombre;
    private String segundo_Nombre;
    private String primer_Apellido;
    private String segundo_Apellido;
    private String direccion;
    private String email;
    private String telefono;

    public Propietario(int id_Propietario, String primer_Nombre, String segundo_Nombre, String primer_Apellido,
                       String segundo_Apellido, String direccion, String email, String telefono) {
        this.id_Propietario = id_Propietario;
        this.primer_Nombre = primer_Nombre;
        this.segundo_Nombre = segundo_Nombre;
        this.primer_Apellido = primer_Apellido;
        this.segundo_Apellido = segundo_Apellido;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }

    public Propietario() {

    }

    // Getters y Setters
    public int getIdPropietario() {
        return id_Propietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.id_Propietario = idPropietario;
    }

    public String getPrimerNombre() {
        return primer_Nombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primer_Nombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundo_Nombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundo_Nombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primer_Apellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primer_Apellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundo_Apellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundo_Apellido = segundoApellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Método de validación
    public boolean isValid() {
        return !primer_Nombre.isEmpty() && !primer_Apellido.isEmpty() && !email.isEmpty()
                && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}