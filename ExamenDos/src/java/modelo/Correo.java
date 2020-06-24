/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public class Correo {

    public Correo(int id_correo, String emisor, String destinatario, String asunto, String mensaje, boolean estado) {
        this.id_correo = id_correo;
        this.emisor = emisor;
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.estado = estado;
    }
    
    public Correo() {
        this(0, null, null, null, null, false);
    }
    
    @Override
    public String toString() {
        return "Correo{" + "id_correo=" + id_correo + ", emisor=" + emisor + ", destinatario=" + destinatario + ", asunto=" + asunto + ", mensaje=" + mensaje + ", estado=" + estado + '}';
    }

    public int getId_correo() {
        return id_correo;
    }

    public String getEmisor() {
        return emisor;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public boolean isEstado() {
        return estado;
    }
    
    private final int id_correo;
    private final String emisor;
    private final String destinatario;
    private final String asunto;
    private final String mensaje;
    private final boolean estado;
}
