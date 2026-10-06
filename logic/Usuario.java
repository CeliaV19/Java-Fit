/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.io.Serializable;

/**
 * La clase usuario es una clase abstracta con atributos que coinciden con admin
 * y socio de manera que ambos hereden de esta clase, que por eso es abstracta
 *
 * @author celia
 */
public abstract class Usuario implements Serializable {

    //Atributos:
    private String correo;
    private String clave;

    /**
     * Constructor de Usuario.
     *
     * @param correo String correo electrónico del usuario que será admin o
     * socio
     * @param clave String contraseña del usuario asignado al correo
     */
    public Usuario(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }

    /**
     * Devuelve el correo del usuario.
     *
     * @return String correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Devuelve la clave del usuario.
     *
     * @return String clave
     */
    public String getClave() {
        return clave;
    }
    /**
     * No implementa setters para evitar que se puedan dar errores o cambiar la
     * clave y el correo al ser datos tan importantes
     */
}
