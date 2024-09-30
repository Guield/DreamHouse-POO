package sv.edu.udb.form;

import java.util.Date;

public class Empleado {
    private int idEmpleado;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String direccion;
    private String categoriaLaboral;
    private double salario;
    private String email;
    private Date fechaNacimiento;
    private int edad;
    private int idSucursal;

    // Constructor
    public Empleado(int idEmpleado, String primerNombre, String segundoNombre, String primerApellido,
                    String segundoApellido, String direccion, String categoriaLaboral, double salario,
                    String email, Date fechaNacimiento, int edad, int idSucursal) {
        this.idEmpleado = idEmpleado;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.direccion = direccion;
        this.categoriaLaboral = categoriaLaboral;
        this.salario = salario;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.idSucursal = idSucursal;
    }

    public Empleado() {

    }

    // Getters y Setters
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCategoriaLaboral() {
        return categoriaLaboral;
    }

    public void setCategoriaLaboral(String categoriaLaboral) {
        this.categoriaLaboral = categoriaLaboral;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public boolean isValid() {
        return !primerNombre.isEmpty() && !primerApellido.isEmpty() && !email.isEmpty()
                && email.matches("^[A-Za-z0-9+_.-]+@(.+)$") && edad > 0
                && salario > 0 && idSucursal > 0;
    }
}