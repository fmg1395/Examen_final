/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

/**
 *
 * @author jorih
 */
public enum IMEC_Usuario {
    INSERTAR("INSERT INTO usuario (`correo`, `password`) VALUES (?, ?); "),
    MODIFICAR("UPDATE usuario SET `password`=? WHERE `correo`=?; "),
    EXCLUIR("DELETE FROM usuario WHERE `correo`=?; "),
    CONSULTAR("SELECT `correo`, `password` FROM usuario WHERE `correo`=? AND `password`=?; "),
    LISTAR("SELECT `correo`, `password` FROM usuario ORDER BY `correo`; "),
    VERIFICAR("SELECT `correo` FROM usuario WHERE `correo`=? AND `password`=?; ");

    IMEC_Usuario(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
