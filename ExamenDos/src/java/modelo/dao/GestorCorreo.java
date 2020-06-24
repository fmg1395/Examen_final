/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import datos.BaseDatos;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Correo;
import modelo.Usuario;


public class GestorCorreo implements Serializable {
     // <editor-fold defaultstate="collapsed" desc="constructores">
    public GestorCorreo() {
        this.bd = BaseDatos.obtenerInstancia();
    }

    public static GestorCorreo obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorCorreo();
        }
        return instancia;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="métodos">
    public boolean registrarCorreo(Correo nuevoCorreo) {
        boolean exito = false;
        int registrosActualizados = 0;
        try {
            Connection cnx = bd.obtenerConexion();

            try (PreparedStatement stm = cnx.prepareStatement(IMEC_Correo.INSERTAR.obtenerComando())) {
                stm.clearParameters();
                stm.setInt(1, nuevoCorreo.getId_correo());
                stm.setString(2, nuevoCorreo.getEmisor());
                stm.setString(3, nuevoCorreo.getDestinatario());
                stm.setString(4, nuevoCorreo.getAsunto());
                stm.setString(5, nuevoCorreo.getMensaje());
                stm.setBoolean(6, nuevoCorreo.isEstado());
                registrosActualizados = stm.executeUpdate();
                exito = registrosActualizados == 1;
            }

        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        } finally {
            bd.cerrarConexion();
        }
        return exito;
    }

    public Correo recuperarCorreo(int id_correo, String emisor, String destinatario, String asunto, String mensaje, boolean estado) {
        Correo r = null;
        try {
            Connection cnx = bd.obtenerConexion();
            try (PreparedStatement stm = cnx.prepareStatement(IMEC_Correo.CONSULTAR.obtenerComando())) {
                stm.clearParameters();
                stm.setInt(1, id_correo);
                ResultSet rs = stm.executeQuery();
                if (rs.next()) {
                    r = new Correo(
                        rs.getInt("id_correo"),
                        rs.getString("emisor"),
                        rs.getString("destinatario"),
                        rs.getString("asunto"),
                        rs.getString("mensaje"),
                        rs.getBoolean("estado")
                    );
                }
            }

        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        } finally {
            bd.cerrarConexion();
        }
        return r;
    }

    public void actualizarAcceso(Correo correoActual) {
        throw new UnsupportedOperationException();
    }

    public List<Correo> obtenerLista() {
        List<Correo> correos = new ArrayList<>();

        // Abre una conexión a la base de datos y carga la lista de usuarios.
        try {
            Connection cnx = bd.obtenerConexion();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(IMEC_Usuario.LISTAR.obtenerComando());
            while (rs.next()) {
                Correo registro = new Correo(
                    rs.getInt("id_correo"),
                    rs.getString("emisor"),
                    rs.getString("destinatario"),
                    rs.getString("asunto"),
                    rs.getString("mensaje"),
                    rs.getBoolean("estado")
                );
                correos.add(registro);
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        } finally {
            bd.cerrarConexion();
        }

        return correos;
    }

    public String listaCorreosHTML() {
        StringBuilder r = new StringBuilder();
        List<Correo> correos = obtenerLista();
        if (correos.size() > 0) {
            for (Correo u : correos) {
                r.append("\t<tr>\n");
                r.append(String.format("\t\t<td>%s</td>%n", u.getId_correo()));
                r.append(String.format("\t\t<td>%s</td>%n", u.getEmisor()));
                r.append(String.format("\t\t<td>%s</td>%n", u.getDestinatario()));
                r.append(String.format("\t\t<td>%s</td>%n", u.getAsunto()));
                r.append(String.format("\t\t<td>%s</td>%n", u.getMensaje()));
                r.append(String.format("\t\t<td>%s</td>%n", u.isEstado()));
                r.append("\t</tr>\n");
            }
        } else {
            r.append("<tr><td colspan=\"4\">(No hay registros en la base de datos.)</td></tr>");
        }

        return r.toString();
    }

    public static String listaCorreosHTML(GestorUsuario g) {
        return g.listaUsuariosHTML();
    }

    public boolean verificarCorreo(int id_correo) {
        boolean encontrado = false;
        try {
            Connection cnx = bd.obtenerConexion();
            try (PreparedStatement stm = cnx.prepareStatement(IMEC_Correo.VERIFICAR.obtenerComando())) {
                stm.clearParameters();
                stm.setInt(1, id_correo);
                ResultSet rs = stm.executeQuery();
                encontrado = rs.next();
            }

        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        } finally {
            bd.cerrarConexion();
        }
        return encontrado;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        GestorCorreo g = GestorCorreo.obtenerInstancia();
        List correos = g.obtenerLista();

        System.out.println("[");
        for (Object e : correos) {
            System.out.printf("\t%s,%n", e);
        }
        System.out.println("]");
        System.out.println();

        System.out.println(g.listaCorreosHTML());
        System.out.println();
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="atributos BD">
    private static GestorCorreo instancia = null;
    private BaseDatos bd = null;
    // </editor-fold>
}
