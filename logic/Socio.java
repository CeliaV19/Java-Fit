/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.io.Serializable;

/**
 * La clase socio es clase hija de Usuario heredando sus atributos y añadiendo
 * sus atributos especificos
 *
 * @author celia
 */
public class Socio extends Usuario implements Serializable {

    private String nombre;
    private String telefono;
    private String direccion;
    private String tarjetaCredito;
    private boolean socioVip;

    /**
     * Constructor: Hereda:
     *
     * @param correo del socio
     * @param clave del socio Añade:
     * @param nombre nombre del socio
     * @param telefono telefono del socio
     * @param direccion direccion del socio
     * @param tarjetaCredito direccion del socio
     * @param socioVip para saber si el socio es de tipo vip o de tipo base
     * (para la cantidad a pagar en la mensualidad)
     *
     */
    public Socio(String nombre, String telefono, String direccion, String tarjetaCredito, boolean socioVip, String correo, String clave) {
        super(correo, clave);
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tarjetaCredito = tarjetaCredito;
        this.socioVip = socioVip;
    }

    /**
     * Get the value of socioVip
     *
     * @return the value of socioVip
     */
    public boolean isSocioVip() {
        return socioVip;
    }

    /**
     * Set the value of socioVip
     *
     * @param socioVip new value of socioVip
     */
    public void setSocioVip(boolean socioVip) {
        this.socioVip = socioVip;
    }

    /**
     * Get the value of tarjetaCredito
     *
     * @return the value of tarjetaCredito
     */
    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    /**
     * Set the value of tarjetaCredito
     *
     * @param tarjetaCredito new value of tarjetaCredito
     */
    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    /**
     * Get the value of direccion
     *
     * @return the value of direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Set the value of direccion
     *
     * @param direccion new value of direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Get the value of telefono
     *
     * @return the value of telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Set the value of telefono
     *
     * @param telefono new value of telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return mensualidad a pagar segun el tipo de socio (50 o 25 euros)
     */
    public double mensualidad() {
        if (this.socioVip) {
            return 50.0;
        } else {
            return 25.0;
        }
    }

    /**
     *
     * @param precioBase
     * @return precio de las actividades especiales y servicios del gimnasio con
     * descuento por ser socio vip o con el precio base si eres socio base
     */
    public double precioActividadesYServicios(double precioBase) {
        if (this.socioVip) {
            return precioBase * 0.9;
        } else {
            return precioBase;
        }
    }

    /**
     *
     * @return los atributos de la clase y su valor por pantalla
     */
    @Override
    public String toString() {
        return "Socio{" + "nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", tarjetaCredito=" + tarjetaCredito + ", socioVip=" + socioVip + '}';
    }

}
