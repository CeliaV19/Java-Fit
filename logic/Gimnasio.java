/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.List;
import java.util.Comparator;

/**
 * Clase central del proyecto, maneja el resto de clases entonces tendra metodos
 * de los tipos de socios para el login, darse de baja, entre otros, para las
 * actividades permitirá crear nuevas entre otras funciones y en reserva entre
 * otros métodos creará el .txt con los datos de reserva. Además, se encargará
 * de llevar a cabo la serialización de crear archivos de bytes y guardar
 * objetos con la info de la app para que estos datos se guarden al abrir y
 * cerrar la app (serialización)
 *
 * @author celia
 */
public class Gimnasio implements Serializable {

    private ArrayList<Actividad> actividades;
    private ArrayList<Socio> socios;
    private ArrayList<Reserva> reservas;
    private ArrayList<Administrador> administradores;
    private ArrayList<Sala> salas;

    private static Gimnasio gimnasio; //Static para evitar un bucle infinito y romper la memoria del pc

    /**
     * Constructor que no recibe ningun parametro ya que se crean los nuevos
     * arrays de cada tipo
     */
    public Gimnasio() {
        salas = new ArrayList<>();
        actividades = new ArrayList<>();
        socios = new ArrayList<>();
        reservas = new ArrayList<>();
        administradores = new ArrayList<>();

        // Añado el administrador por defecto para entrar como admin:
        administradores.add(new Administrador("admin@javafit.com", "admin"));

        salas.add(new Sala("piscina principal", 30));
        salas.add(new Sala("piscina infantil", 15));
        salas.add(new Sala("sala ciclo", 20));
        salas.add(new Sala("sala hyrox", 20));
        salas.add(new Sala("sala fuerza", 50));
        salas.add(new Sala("sala crossfit", 12));
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    /**
     * Obtiene la lista de salas asignadas alguna actividad evitando duplicados
     *
     * @return ArrayList con las salas creadas
     */
    public ArrayList<Sala> getSalas() {
        return salas;

    }

    public void setActividades(ArrayList<Actividad> actividad) {
        this.actividades = actividad;
    }

    public ArrayList<Socio> getSocios() {
        return socios;
    }

    public void setSocios(ArrayList<Socio> socio) {
        this.socios = socio;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reserva) {
        this.reservas = reserva;
    }

    public ArrayList<Administrador> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(ArrayList<Administrador> administrador) {
        this.administradores = administrador;
    }

    /**
     * Metodo para comprobar si el correo y la clave del admin son correctos al
     * hacer login
     *
     * @param correo
     * @param clave
     * @return el administrador si coinciden ambos o null si no existe
     */
    public Administrador loginAdmin(String correo, String clave) {
        return administradores.stream()
                .filter(a -> a.getCorreo().equals(correo) && a.getClave().equals(clave))
                .findFirst()
                .orElse(null);
    }

    /**
     * Metodo para comprobar si el correo y la clave del admin son correctos al
     * hacer login
     *
     * @param correo
     * @param clave
     * @return el socio si coinciden ambos o null si no existe
     */
    public Socio loginSocio(String correo, String clave) {
        return socios.stream()
                .filter(s -> s.getCorreo().equals(correo) && s.getClave().equals(clave))
                .findFirst()
                .orElse(null);
    }

    /**
     * Metodo que recorre los socios para ver si el correo que introduce un
     * usuario ya esta registrado
     *
     * @param correo para comparar
     * @return true si ya existe el correo o false si no
     */
    public boolean existeCorreo(String correo) {
        for (Socio s : socios) {
            if (s.getCorreo().equals(correo)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Registrar un nuevo socio mirando antes si el correo ya esta en la lista
     *
     * @param socio objeto socio con sus datos personales
     * @return false si el correo ya existe, true si no existe
     */
    public boolean altaSocio(Socio socio) {
        if (existeCorreo(socio.getCorreo())) {
            return false;
        } else {
            socios.add(socio);
            return true;
        }
    }

    /**
     * Metodo para eliminar a un socio del sistema buscando si existe en la
     * lista
     *
     * @param socio
     * @return true si lo borra correctamente o false si no se encuentra
     */
    public boolean bajaSocio(Socio socio) {
        if (!existeCorreo(socio.getCorreo())) {
            return false;
        } else {
            socios.remove(socio);
            return true;
        }
    }

    /**
     * Guardar toda la informacion del gimnasio en un archivo de bytes fichero
     * gimnasio.dat para que no se pierdan los datos al cerrar la app
     */
    public void guardarDatos() {
        try {
            FileOutputStream fos = new FileOutputStream("gimnasio.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            System.out.println("Se han guardado los datos");
        } catch (FileNotFoundException e) {
            System.out.println("Ha surgido un error al no encontrar el fichero:" + e.getMessage());
        } catch (IOException ioe) {
            System.out.println("Ha surgido un error en la entrada y salida de los datos:" + ioe.getMessage());
        }

    }

    /**
     * Metodo para leer el archivo gimnasio.dat y tener los datos gimnasio con
     * todos sus socios, actividades y reservas guardadas al volver a abrir la
     * app
     *
     * @return el objeto gimnasio con todos los datos o uno nuevo si el archivo
     * no existe todavia
     */
    public static Gimnasio cargarDatos() {
        Gimnasio gimnasio = new Gimnasio();
        try {

            FileInputStream fis = new FileInputStream("gimnasio.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            gimnasio = (Gimnasio) ois.readObject();
            ois.close();
            System.out.println("Se han cargado todos los datos");

        } catch (Exception e) {
            System.out.println("Ha habido un error" + e.getMessage());
        }
        return gimnasio;
    }

    /**
     * Metodo para generar un archivo de texto .txt que genera un ticket de
     * reserva con los datos de la actividad, del socio y el importe pagado
     *
     * @param r objeto de la reserva
     */
    public static void generarRecibo(Reserva r) {
        try {
            PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter("recibo_" + r.getSocio().getNombre() + "_" + r.getSocio().getTelefono() + ".txt")));
            salida.println("----------------");
            salida.println("-----RECIBO-----");
            salida.println("----------------");
            salida.println("Actividad:" + r.getActividad());
            salida.println("Socio:" + r.getSocio());
            salida.println("Dia en el que se impartira la actividad:" + r.getFechaClase());
            salida.println("Fecha en la que se ha realizado la reserva:" + r.getFechaRegistro());
            salida.println("Importe pagado:" + r.getImporte());
            salida.println("-----------------");

            salida.close();
        } catch (IOException ioe) {
            System.out.println("Error en la entrada y salida de los datos al generar el recibo de la reserva:" + ioe.getMessage());
        }
    }

    /**
     * Streams para ordenar la lista de todas las reservas en base a la fecha en
     * la que se realizaron
     *
     * @return lista de reservas ordenada por fecha de registro
     */
    public List<Reserva> ordenarReservas() {
        return reservas.stream()
                .sorted(Comparator.comparing(Reserva::getFechaRegistro))
                .collect(Collectors.toList());

    }

    /**
     * Metodo para tramitar una reserva comprobando si queda aforo en la sala y
     * calcula el precio final si es una actividad especial y aplicando el 10%
     * de descuento si el socio es VIP
     *
     * @param actividad
     * @param socio
     * @param fechaClase
     * @param importe
     * @return true si la reserva se ha podido hacer o false si el aforo esta
     * completo
     */
    public boolean realizarReserva(Actividad actividad, Socio socio, java.time.LocalDate fechaClase, double importe) {
        long reservasRealizadas = reservas.stream()
                .filter(r -> r.getActividad().getTitulo().equals(actividad.getTitulo()) && r.getFechaClase().equals(fechaClase))
                .count();

        if (reservasRealizadas >= actividad.getSala().getAforoMaximo()) {
            System.out.println("Aforo completo, no puedes reservar esta actividad");
            return false;
        }

        if (actividad instanceof ActividadEspecial) {
            importe = ((ActividadEspecial) actividad).getPrecio();
        }

        double precioFinal = importe;
        if (socio.isSocioVip()) {
            precioFinal = importe * 0.9;
        }
        Reserva r = new Reserva(actividad, socio, fechaClase, precioFinal);

        reservas.add(r);
        generarRecibo(r);
        guardarDatos();

        return true;
    }

    /**
     * Metodo para añadir una nueva actividad gimnasio si no esta añadida ya
     *
     * @param actividad
     * @return true si la añade o false si ya existe una asi
     */
    public boolean añadirActividad(Actividad actividad) {
        if (actividades.contains(actividad)) {
            return false;
        } else {
            actividades.add(actividad);
            return true;
        }
    }

    /**
     * Metodo para borrar una actividad del gimnasio si está en la lista
     *
     * @param actividad
     * @return true si la borra correctamente o false si no la encuentra
     */
    public boolean eliminarActividad(Actividad actividad) {
        if (!actividades.contains(actividad)) {
            return false;
        } else {
            actividades.remove(actividad);
            return true;
        }
    }

    /**
     * Metodo para buscar una actividad cdel gimnasio por su titulo
     *
     * @param titulo nombre de la actividad
     * @return la actividad
     */
    public Actividad buscarPorTitulo(String titulo) {
        return actividades.stream()
                .filter(a -> a.getTitulo().equals(titulo))
                .findFirst()
                .orElse(null);
    }

}
