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
import modelo.Usuario;


public class GestorUsuario implements Serializable {
     // <editor-fold defaultstate="collapsed" desc="constructores">
    public GestorUsuario() {
        this.bd = BaseDatos.obtenerInstancia();
    }

    public static GestorUsuario obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorUsuario();
        }
        return instancia;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="métodos">
    public boolean registrarUsuario(Usuario nuevoUsuario) {
        boolean exito = false;
        int registrosActualizados = 0;
        try {
            Connection cnx = bd.obtenerConexion();

            try (PreparedStatement stm = cnx.prepareStatement(IMEC_Usuario.INSERTAR.obtenerComando())) {
                stm.clearParameters();
                stm.setString(1, nuevoUsuario.getCorreo());
                stm.setString(2, nuevoUsuario.getPassword());
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

    public Usuario recuperarUsuario(String usuario, String clave) {
        Usuario r = null;
        try {
            Connection cnx = bd.obtenerConexion();
            try (PreparedStatement stm = cnx.prepareStatement(IMEC_Usuario.CONSULTAR.obtenerComando())) {
                stm.clearParameters();
                stm.setString(1, usuario);
                stm.setString(2, clave);
                ResultSet rs = stm.executeQuery();
                if (rs.next()) {
                    r = new Usuario(
                        rs.getString("correo"),
                        rs.getString("password")
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

    public void actualizarAcceso(Usuario usuarioActual) {
        throw new UnsupportedOperationException();
    }

    public List<Usuario> obtenerLista() {
        List<Usuario> usuarios = new ArrayList<>();

        // Abre una conexión a la base de datos y carga la lista de usuarios.
        try {
            Connection cnx = bd.obtenerConexion();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(IMEC_Usuario.LISTAR.obtenerComando());
            while (rs.next()) {
                Usuario registro = new Usuario(
                    rs.getString("correo"),
                    rs.getString("password")
                );
                usuarios.add(registro);
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        } finally {
            bd.cerrarConexion();
        }

        return usuarios;
    }

    public String listaUsuariosHTML() {
        StringBuilder r = new StringBuilder();
        List<Usuario> usuarios = obtenerLista();
        if (usuarios.size() > 0) {
            for (Usuario u : usuarios) {
                r.append("\t<tr>\n");
                r.append(String.format("\t\t<td>%s</td>%n", u.getCorreo()));
                r.append(String.format("\t\t<td>%s</td>%n", u.getPassword()));
                r.append("\t</tr>\n");
            }
        } else {
            r.append("<tr><td colspan=\"4\">(No hay registros en la base de datos.)</td></tr>");
        }

        return r.toString();
    }

    public static String listaUsuariosHTML(GestorUsuario g) {
        return g.listaUsuariosHTML();
    }

    public boolean verificarUsuario(String usuario, String clave) {
        boolean encontrado = false;
        try {
            Connection cnx = bd.obtenerConexion();
            try (PreparedStatement stm = cnx.prepareStatement(IMEC_Usuario.VERIFICAR.obtenerComando())) {
                stm.clearParameters();
                stm.setString(1, usuario);
                stm.setString(2, clave);
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
        GestorUsuario g = GestorUsuario.obtenerInstancia();
        List usuarios = g.obtenerLista();

        System.out.println("[");
        for (Object e : usuarios) {
            System.out.printf("\t%s,%n", e);
        }
        System.out.println("]");
        System.out.println();

        System.out.println(g.listaUsuariosHTML());
        System.out.println();
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="atributos BD">
    private static GestorUsuario instancia = null;
    private BaseDatos bd = null;
    // </editor-fold>
}
