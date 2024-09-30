package sv.edu.udb.service;

import sv.edu.udb.form.Empleado;
import java.util.List;

public interface IEmpleadoService {
    void crearEmpleado(Empleado empleado);
    void editarEmpleado(Empleado empleado);
    void eliminarEmpleado(int idEmpleado);
    Empleado obtenerEmpleado(int idEmpleado);
    List<Empleado> obtenerTodosEmpleados();
}
