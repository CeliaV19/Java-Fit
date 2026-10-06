/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.io.Serializable;

/**
 * La clase sala se utilizará como atributo instanciando un objeto de tipo sala
 * con la informacion de su nombre y aforo maximo, como son datos inmutables
 * solo creo los metodos get de cada uno, en vez de los getters y setters en
 * conjunto
 *
 * @author celia
 */
public class Sala implements Serializable {

    private String nombre;
    public int aforoMaximo; //para poder acceder a su aforo desde las reservas de la actividad

    /**
     * Constructor para poder instanciar objetos de clase sala (sala de pesas,
     * de yoga, etc.)
     *
     * @param nombre
     * @param aforoMaximo
     */
    public Sala(String nombre, int aforoMaximo) {
        this.nombre = nombre;
        this.aforoMaximo = aforoMaximo;
    }

    /**
     * Get the value of aforoMaximo
     *
     * @return the value of aforoMaximo
     */
    public int getAforoMaximo() {
        return aforoMaximo;
    }

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * toString para mostrar en la gui para elegir sala al acceder como usuario
     * y querer crear una nueva actividad
     *
     * @return atributos de la clase y sus valores de la clase por pantalla
     */
    @Override
    public String toString() {
        return  nombre + " con aforo de: " + aforoMaximo+ " personas";
    }

}
