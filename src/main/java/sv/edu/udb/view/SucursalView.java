package sv.edu.udb.view;

import sv.edu.udb.form.Sucursal;
import sv.edu.udb.service.SucursalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/sucursal")
public class SucursalView extends HttpServlet {
    private SucursalService sucursalService;

    @Override
    public void init() throws ServletException {
        super.init();
        sucursalService = new SucursalService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("list".equals(action)) {
            List<Sucursal> sucursales = sucursalService.obtenerSucursales();
            request.setAttribute("sucursales", sucursales);
            response.sendRedirect("webapp/views/sucursales/list.jsp");
        } else if ("new".equals(action)) {
            request.getRequestDispatcher("views/sucursales/new.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Sucursal sucursal = sucursalService.obtenerSucursales().stream()
                    .filter(s -> s.getIdSucursal() == id)
                    .findFirst()
                    .orElse(null);
            request.setAttribute("sucursal", sucursal);
            request.getRequestDispatcher("views/sucursales/edit.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            String direccionCalle = request.getParameter("direccionCalle");
            String direccionColonia = request.getParameter("direccionColonia");
            String ciudad = request.getParameter("ciudad");
            String departamento = request.getParameter("departamento");
            String telefono = request.getParameter("telefono");
            int idEmpleadoDirige = Integer.parseInt(request.getParameter("idEmpleadoDirige"));

            Sucursal nuevaSucursal = new Sucursal(0, direccionCalle, direccionColonia, ciudad, departamento, telefono, idEmpleadoDirige);
            if (nuevaSucursal.isValid() && sucursalService.agregarSucursal(nuevaSucursal)) {
                response.sendRedirect("sucursal?action=list");
            } else {
                request.setAttribute("error", "Error al agregar la sucursal. Verifique los datos.");
                request.getRequestDispatcher("views/sucursales/new.jsp").forward(request, response);
            }
        } else if ("update".equals(action)) {
            int idSucursal = Integer.parseInt(request.getParameter("idSucursal"));
            String direccionCalle = request.getParameter("direccionCalle");
            String direccionColonia = request.getParameter("direccionColonia");
            String ciudad = request.getParameter("ciudad");
            String departamento = request.getParameter("departamento");
            String telefono = request.getParameter("telefono");
            int idEmpleadoDirige = Integer.parseInt(request.getParameter("idEmpleadoDirige"));

            Sucursal sucursalActualizada = new Sucursal(idSucursal, direccionCalle, direccionColonia, ciudad, departamento, telefono, idEmpleadoDirige);
            if (sucursalActualizada.isValid() && sucursalService.editarSucursal(sucursalActualizada)) {
                response.sendRedirect("sucursal?action=list");
            } else {
                request.setAttribute("error", "Error al editar la sucursal. Verifique los datos.");
                request.getRequestDispatcher("views/sucursales/edit.jsp").forward(request, response);
            }
        } else if ("delete".equals(action)) {
            int idSucursal = Integer.parseInt(request.getParameter("idSucursal"));
            if (sucursalService.eliminarSucursal(idSucursal)) {
                response.sendRedirect("sucursal?action=list");
            } else {
                request.setAttribute("error", "Error al eliminar la sucursal.");
                request.getRequestDispatcher("views/sucursales/list.jsp").forward(request, response);
            }
        }
    }
}