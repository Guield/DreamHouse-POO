package sv.edu.udb.service;

import sv.edu.udb.form.Sucursal;
import java.util.List;

public interface ISucursalService {
    void crearSucursal(Sucursal sucursal);
    void editarSucursal(Sucursal sucursal);
    void eliminarSucursal(int idSucursal);
    Sucursal obtenerSucursal(int idSucursal);
    List<Sucursal> obtenerTodasSucursales();
}