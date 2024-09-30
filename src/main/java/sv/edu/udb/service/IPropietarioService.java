package sv.edu.udb.service;

import sv.edu.udb.form.Propietario;
import java.util.List;

public interface IPropietarioService {
    void crearPropietario(Propietario propietario);
    void editarPropietario(Propietario propietario);
    void eliminarPropietario(int idPropietario);
    Propietario obtenerPropietario(int idPropietario);
    List<Propietario> obtenerTodosPropietarios();
}