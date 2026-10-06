/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase actividad para instanciar objetos de tipo actividad que aparte de las
 * gestiones de reservas en la clase principal gimnasio gestiona su propia lista
 * de reservas para saber extactamente cuantas reservas se han dado en esta
 * actividad en especifico y comparar asi con el aforo maximo de la sala
 *
 * @author celia
 */
public class Actividad implements Serializable{

    private String titulo;
    private TipoActividad tipo;
    private Sala sala;
    private String diasSemana;
    private String horarioInicio;
    private String horarioFin;
    private String monitor;
    private String imagen;
    private ArrayList<Reserva> listaReservas;

    /**
     * Constructor para instanciar objetos de tipo actividad con los siguientes
     * atributos:
     *
     * @param titulo
     * @param tipo
     * @param sala
     * @param diasSemana
     * @param horarioInicio
     * @param horarioFin
     * @param monitor
     * @param imagen
     */
    public Actividad(String titulo, TipoActividad tipo, Sala sala, String diasSemana, String horarioInicio, String horarioFin, String monitor, String imagen) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.sala = sala;
        this.diasSemana = diasSemana;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
        this.monitor = monitor;
        this.imagen = imagen;
        this.listaReservas = new ArrayList<>();
    }
    
    public Actividad(String titulo,TipoActividad tipo, Sala sala,String diasSemana, String horarioInicio, String horarioFin, String monitor){
        this.titulo = titulo;
        this.tipo = tipo;
        this.sala = sala;
        this.diasSemana = diasSemana;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
        this.monitor = monitor;}

    /**
     * Get the value of imagen
     *
     * @return the value of imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Set the value of imagen
     *
     * @param imagen new value of imagen
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Get the value of listaReservas
     *
     * @return the value of listaReservas
     */
    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    /**
     * Set the value of listaReservas
     *
     * @param listaReservas new value of listaReservas
     */
    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    /**
     * Get the value of monitor
     *
     * @return the value of monitor
     */
    public String getMonitor() {
        return monitor;
    }

    /**
     * Set the value of monitor
     *
     * @param monitor new value of monitor
     */
    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    /**
     * Get the value of horarioFin
     *
     * @return the value of horarioFin
     */
    public String getHorarioFin() {
        return horarioFin;
    }

    /**
     * Set the value of horarioFin
     *
     * @param horarioFin new value of horarioFin
     */
    public void setHorarioFin(String horarioFin) {
        this.horarioFin = horarioFin;
    }

    /**
     * Get the value of horarioInicio
     *
     * @return the value of horarioInicio
     */
    public String getHorarioInicio() {
        return horarioInicio;
    }

    /**
     * Set the value of horarioInicio
     *
     * @param horarioInicio new value of horarioInicio
     */
    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    /**
     * Get the value of diasSemana
     *
     * @return the value of diasSemana
     */
    public String getDiasSemana() {
        return diasSemana;
    }

    /**
     * Set the value of diasSemana
     *
     * @param diasSemana new value of diasSemana
     */
    public void setDiasSemana(String diasSemana) {
        this.diasSemana = diasSemana;
    }

    /**
     * Get the value of sala
     *
     * @return the value of sala
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * Set the value of sala
     *
     * @param sala new value of sala
     */
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    /**
     * Get the value of tipo
     *
     * @return the value of tipo
     */
    public TipoActividad getTipo() {
        return tipo;
    }

    /**
     * Set the value of tipo
     *
     * @param tipo new value of tipo
     */
    public void setTipo(TipoActividad tipo) {
        this.tipo = tipo;
    }

    /**
     * Get the value of titulo
     *
     * @return the value of titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Set the value of titulo
     *
     * @param titulo new value of titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return verdadero o falso mirando el atributo de aforo maximo de la sala
     * que se ha instanciado y comprobando que la longitud de la lista de
     * reservas, es decir, el numero de personas que han reservado esta
     * actividad sea menor que este aforo, no necesita recibir ningun parametro
     * porque sala ya es un atributo de la clase
     */
    public boolean aforoDisponible() {
        return listaReservas.size() < sala.aforoMaximo;//Retornará verdadero o falso dependiendo de si se cumple accediendo a la clase sala a partir de un objeto

    }

    /**
     *
     * @return imprimir por pantalla los datos de la actividad para mostrarlos
     * en la gui
     */
    @Override
    public String toString() {
        return "Actividad: "+ titulo.toUpperCase() + "\n"+ "de tipo: " + tipo + "\n"+ "en: " + sala + "\n"+ "los días: " + diasSemana + "\n"+ "comienza en la hora: " + horarioInicio + "\n"+ "y acaba en la hora: " + horarioFin + "\n"+ "impartida por: " + monitor.toUpperCase() ;
    }

}
