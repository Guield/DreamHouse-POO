package sv.edu.udb.view;

import sv.edu.udb.form.Empleado;
import sv.edu.udb.service.EmpleadoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/empleado")
public class EmpleadoView extends HttpServlet {
    private EmpleadoService empleadoService;

    @Override
    public void init() throws ServletException {
        super.init();
        empleadoService = new EmpleadoService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("list".equals(action)) {
            List<Empleado> empleados = empleadoService.obtenerEmpleado();
            request.setAttribute("empleados", empleados);
            request.getRequestDispatcher("views/empleados/list.jsp").forward(request, response);
        } else if ("new".equals(action)) {
            request.getRequestDispatcher("views/empleados/new.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Empleado empleado = empleadoService.obtenerEmpleado().stream()
                    .filter(e -> e.getIdEmpleado() == id)
                    .findFirst()
                    .orElse(null);
            request.setAttribute("empleado", empleado);
            request.getRequestDispatcher("views/empleados/edit.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            String primerNombre = request.getParameter("primerNombre");
            String segundoNombre = request.getParameter("segundoNombre");
            String primerApellido = request.getParameter("primerApellido");
            String segundoApellido = request.getParameter("segundoApellido");
            String direccion = request.getParameter("direccion");
            String categoriaLaboral = request.getParameter("categoriaLaboral");
            double salario = Double.parseDouble(request.getParameter("salario"));
            String email = request.getParameter("email");
            String fechaNacimientoStr = request.getParameter("fechaNacimiento");
            int idSucursal = Integer.parseInt(request.getParameter("idSucursal"));

            // Conversión de String a Date
            java.sql.Date fechaNacimiento = null;
            try {
                java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimientoStr);
                fechaNacimiento = new java.sql.Date(utilDate.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Empleado nuevoEmpleado = new Empleado(0, primerNombre, segundoNombre, primerApellido, segundoApellido,
                    direccion, categoriaLaboral, salario, email, fechaNacimiento, 0, idSucursal);
            if (nuevoEmpleado.isValid() && empleadoService.agregarEmpleado(nuevoEmpleado)) {
                response.sendRedirect("empleado?action=list");
            } else {
                request.setAttribute("error", "Error al agregar el empleado. Verifique los datos.");
                request.getRequestDispatcher("views/empleados/new.jsp").forward(request, response);
            }
        } else if ("update".equals(action)) {
            int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
            String primerNombre = request.getParameter("primerNombre");
            String segundoNombre = request.getParameter("segundoNombre");
            String primerApellido = request.getParameter("primerApellido");
            String segundoApellido = request.getParameter("segundoApellido");
            String direccion = request.getParameter("direccion");
            String categoriaLaboral = request.getParameter("categoriaLaboral");
            double salario = Double.parseDouble(request.getParameter("salario"));
            String email = request.getParameter("email");
            String fechaNacimientoStr = request.getParameter("fechaNacimiento");
            int idSucursal = Integer.parseInt(request.getParameter("idSucursal"));

            // Conversión de String a Date
            java.sql.Date fechaNacimiento = null;
            try {
                java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimientoStr);
                fechaNacimiento = new java.sql.Date(utilDate.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Empleado empleadoActualizado = new Empleado(idEmpleado, primerNombre, segundoNombre, primerApellido,
                    segundoApellido, direccion, categoriaLaboral, salario, email, fechaNacimiento, 0, idSucursal);
            if (empleadoActualizado.isValid() && empleadoService.editarEmpleado(empleadoActualizado)) {
                response.sendRedirect("empleado?action=list");
            } else {
                request.setAttribute("error", "Error al editar el empleado. Verifique los datos.");
                request.getRequestDispatcher("views/empleados/edit.jsp").forward(request, response);
            }
        }
    }
}