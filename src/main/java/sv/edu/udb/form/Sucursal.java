package sv.edu.udb.form;

public class Sucursal {
    private int idSucursal;
    private String direccionCalle;
    private String direccionColonia;
    private String ciudad;
    private String departamento;
    private String telefono;
    private int idEmpleadoDirige;

    public Sucursal(int idSucursal, String direccionCalle, String direccionColonia, String ciudad,
                    String departamento, String telefono, int idEmpleadoDirige) {
        this.idSucursal = idSucursal;
        this.direccionCalle = direccionCalle;
        this.direccionColonia = direccionColonia;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.telefono = telefono;
        this.idEmpleadoDirige = idEmpleadoDirige;
    }

    public Sucursal() {

    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getDireccionCalle() {
        return direccionCalle;
    }

    public void setDireccionCalle(String direccionCalle) {
        this.direccionCalle = direccionCalle;
    }

    public String getDireccionColonia() {
        return direccionColonia;
    }

    public void setDireccionColonia(String direccionColonia) {
        this.direccionColonia = direccionColonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdEmpleadoDirige() {
        return idEmpleadoDirige;
    }

    public void setIdEmpleadoDirige(int idEmpleadoDirige) {
        this.idEmpleadoDirige = idEmpleadoDirige;
    }

    public boolean isValid() {
        return !direccionCalle.isEmpty() && !direccionColonia.isEmpty() && !ciudad.isEmpty()
                && !departamento.isEmpty() && telefono.matches("\\d{8,15}");
    }
}