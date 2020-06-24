
package modelo.dao;


public enum IMEC_Correo {
    INSERTAR("INSERT INTO correo ( `emisor`, `destinatario`, `asunto`, `mensaje`, `estado`) VALUES (?, ?, ?, ?, ?); "),
    MODIFICAR("UPDATE correo SET `emisor`=?, `destinatario`=?, `asunto`=?, `mensaje`=?, `estado`=? WHERE `id_correo`=?; "),
    EXCLUIR("DELETE FROM correo WHERE `id_correo`=?; "),
    CONSULTAR("SELECT `id_correo`, `emisor`, `destinatario`, `asunto`, `mensaje`, `estado` FROM correo WHERE `id_correo`=?; "),
    LISTAR("SELECT `id_correo`, `emisor`, `destinatario`, `asunto`, `mensaje`, `estado`` FROM correo ORDER BY `id_correo`; "),
    VERIFICAR("SELECT `id_correo`, `asunto` FROM correo WHERE `id_correo`=?; ");

    IMEC_Correo(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}