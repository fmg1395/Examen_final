/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public class Usuario {

    public Usuario(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }
    
    public Usuario() {
        this(null, null);
    }
    
    @Override
    public String toString() {
        return "usuario{" + "correo=" + correo + ", password=" + password + '}';
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }
    
    private final String correo;
    private final String password;
}
