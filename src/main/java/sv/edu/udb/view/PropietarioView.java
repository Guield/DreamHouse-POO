package sv.edu.udb.view;

import sv.edu.udb.form.Propietario;
import sv.edu.udb.service.PropietarioService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/propietario")
public class PropietarioView extends HttpServlet {
    private PropietarioService propietarioService;

    @Override
    public void init() throws ServletException {
        super.init();
        propietarioService = new PropietarioService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("list".equals(action)) {
            List<Propietario> propietarios = propietarioService.obtenerPropietario();
            request.setAttribute("propietarios", propietarios);
            request.getRequestDispatcher("views/propietarios/list.jsp").forward(request, response);
        } else if ("new".equals(action)) {
            request.getRequestDispatcher("./webapp/views/propietarios/new.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Propietario propietario = propietarioService.obtenerPropietario().stream()
                    .filter(p -> p.getIdPropietario() == id)
                    .findFirst()
                    .orElse(null);
            request.setAttribute("propietario", propietario);
            request.getRequestDispatcher("views/propietarios/edit.jsp").forward(request, response);
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
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");

            Propietario nuevoPropietario = new Propietario(0, primerNombre, segundoNombre, primerApellido, segundoApellido, direccion, email, telefono);
            if (nuevoPropietario.isValid() && propietarioService.agregarPropietario(nuevoPropietario)) {
                response.sendRedirect("propietario?action=list");
            } else {
                request.setAttribute("error", "Error al agregar el propietario. Verifique los datos.");
                request.getRequestDispatcher("views/propietarios/new.jsp").forward(request, response);
            }
        } else if ("update".equals(action)) {
            int idPropietario = Integer.parseInt(request.getParameter("idPropietario"));
            String primerNombre = request.getParameter("primerNombre");
            String segundoNombre = request.getParameter("segundoNombre");
            String primerApellido = request.getParameter("primerApellido");
            String segundoApellido = request.getParameter("segundoApellido");
            String direccion = request.getParameter("direccion");
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");

            Propietario propietarioActualizado = new Propietario(idPropietario, primerNombre, segundoNombre, primerApellido, segundoApellido, direccion, email, telefono);
            if (propietarioActualizado.isValid() && propietarioService.editarPropietario(propietarioActualizado)) {
                response.sendRedirect("propietario?action=list");
            } else {
                request.setAttribute("error", "Error al editar el propietario. Verifique los datos.");
                request.getRequestDispatcher("views/propietarios/edit.jsp").forward(request, response);
            }
        } else if ("delete".equals(action)) {
            int idPropietario = Integer.parseInt(request.getParameter("idPropietario"));
            if (propietarioService.eliminarPropietario(idPropietario)) {
                response.sendRedirect("propietario?action=list");
            } else {
                request.setAttribute("error", "Error al eliminar el propietario.");
                request.getRequestDispatcher("views/propietarios/list.jsp").forward(request, response);
            }
        }
    }
}