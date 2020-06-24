package servicios;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Correo;
import modelo.dao.GestorCorreo;

@WebServlet(name = "Servicio_email", urlPatterns = {"/Servicio_email"})
@MultipartConfig
public class Servicio_email extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            JsonObject r = new JsonObject();

            Enumeration<String> p = request.getParameterNames();
            String n = p.nextElement();
            Correo mail = new Gson().fromJson(request.getParameter(n), Correo.class);
            
            boolean verificacion = new GestorCorreo().registrarCorreo(mail);
            
            r.addProperty("respuesta", verificacion);
            out.println(r.toString());

        }catch(JsonSyntaxException ex)
        {
            System.err.printf("Error deserializar email: %s", ex.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
