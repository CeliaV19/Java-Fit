/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.io.Serializable;
import java.time.*;

/**
 * Clase reserva con todos los parametros para generar un recibo.txt que
 * contenga toda la informacion necesaria para que un socio realice una reserva
 * (precio, actividad que reserva, cuando la reserva, cuando se impartirá la
 * clase, etc.)
 *
 * @author celia
 */
public class Reserva implements Serializable {

    private Actividad actividad;
    private Socio socio;
    private LocalDate fechaClase;
    private LocalDateTime fechaRegistro;
    private double importe;

    /**
     * Constructor para instaciar objetos de clase reserva, con los parametros
     * de la actividad que se reserva, el socio que la reserva, la fecha en la
     * que se dará la actividad, para generar el recibo .txt la fecha en la que
     * el socio hizo la reserva y el importe que este ha tenido que pagar para
     * reservar la actividad
     *
     * @param actividad
     * @param socio
     * @param fechaClase
     * @param importe
     */
    public Reserva(Actividad actividad, Socio socio, LocalDate fechaClase, double importe) {
        this.actividad = actividad;
        this.socio = socio;
        this.fechaClase = fechaClase;
        this.fechaRegistro = LocalDateTime.now();
        this.importe = importe;
    }

    /**
     * Get the value of importe
     *
     * @return the value of importe
     */
    public double getImporte() {
        return importe;
    }

    /**
     * Set the value of importe
     *
     * @param importe new value of importe
     */
    public void setImporte(double importe) {
        this.importe = importe;
    }

    /**
     * Get the value of fechaRegistro
     *
     * @return the value of fechaRegistro
     */
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Set the value of fechaRegistro
     *
     * @param fechaRegistro new value of fechaRegistro
     */
    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Get the value of fechaClase
     *
     * @return the value of fechaClase
     */
    public LocalDate getFechaClase() {
        return fechaClase;
    }

    /**
     * Set the value of fechaClase
     *
     * @param fechaClase new value of fechaClase
     */
    public void setFechaClase(LocalDate fechaClase) {
        this.fechaClase = fechaClase;
    }

    /**
     * Get the value of socio
     *
     * @return the value of socio
     */
    public Socio getSocio() {
        return socio;
    }

    /**
     * Set the value of socio
     *
     * @param socio new value of socio
     */
    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    /**
     * Get the value of actividad
     *
     * @return the value of actividad
     */
    public Actividad getActividad() {
        return actividad;
    }

    /**
     * Set the value of actividad
     *
     * @param actividad new value of actividad
     */
    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    /**
     *
     * @return imprime los datos de la clase con sus valores correspondientes
     * para mostrar en la gui la lista de reservas
     */
    @Override
    public String toString() {
        return "Reserva{" + "actividad=" + actividad + ", socio=" + socio + ", fechaClase=" + fechaClase + ", fechaRegistro=" + fechaRegistro + ", importe=" + importe + '}';
    }

}
