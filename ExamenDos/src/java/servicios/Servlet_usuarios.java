package servicios;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;
import modelo.dao.GestorUsuario;

@WebServlet(name = "Servlet_usuarios", urlPatterns = {"/Servlet_usuarios"})
public class Servlet_usuarios extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            JsonObject r = new JsonObject();
            JsonArray js = new JsonArray();
            List<Usuario> lista = new GestorUsuario().obtenerLista();
            
            StringBuilder s = new StringBuilder();
            s.append("[");

            for (int i = 0; i < lista.size() - 1; i++) {
                s.append("{");
                s.append("'correo':'"+lista.get(i).getCorreo());
                s.append("'},");
            }
            s.append("{");
            s.append("'correo':'"+lista.get(lista.size() - 1).getCorreo());
            s.append("'}");
            s.append("]");
            r.addProperty("correos",s.toString());
            out.println(r);
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
    }// </editor-fold>

}
