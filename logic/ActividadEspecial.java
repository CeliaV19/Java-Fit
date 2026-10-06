/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.io.Serializable;

/**
 * Clase que hereda de actividad ya que son actividades tambien que se
 * instancian añadiendo un precio propio y una descripcion de esta actividad
 *
 * @author celia
 */
public class ActividadEspecial extends Actividad implements Serializable {

    private double precio;
    private String descripcion;

    /**
     * Constructor para instanciar objetos de actividades especiales (como
     * podria ser pilates o ciclo) añadiendo los atributos precio y descripcion
     *
     * @param precio
     * @param descripcion
     * @param titulo
     * @param tipo
     * @param sala
     * @param diasSemana
     * @param horarioInicio
     * @param horarioFin
     * @param monitor
     * @param imagen
     */
    public ActividadEspecial(double precio, String descripcion, String titulo, TipoActividad tipo, Sala sala, String diasSemana, String horarioInicio, String horarioFin, String monitor, String imagen) {
        super(titulo, tipo, sala, diasSemana, horarioInicio, horarioFin, monitor, imagen);
        this.precio = precio;
        this.descripcion = descripcion;
    }

    /**
     * Get the value of descripcion
     *
     * @return the value of descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Set the value of descripcion
     *
     * @param descripcion new value of descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Get the value of precio
     *
     * @return the value of precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Set the value of precio
     *
     * @param precio new value of precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     *
     * @return imprime los datos de la actividad especial junto con los
     * atributos de la clase actividad sin repetir gracias al super.toString
     */
    @Override
    public String toString() {
        return super.toString() + ", precio=" + precio + ", descripcion=" + descripcion + "}";
    }
}
