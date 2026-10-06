/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.io.Serializable;

/**
 * Hereda de la clase usuario el correo y la clave que son sus unicos atributos
 * No añade atributos propios ya que accede a todos los datos, accede a todas
 * las listas a partir de la clase gimnasio
 *
 * @author celia
 */
public class Administrador extends Usuario implements Serializable {

    public Administrador(String correo, String clave) {
        super(correo, clave);
    }

}
