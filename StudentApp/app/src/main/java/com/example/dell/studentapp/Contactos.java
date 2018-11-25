package com.example.dell.studentapp;

/**
 * Clase encargada de manejar los contactos en la app
 */
public class Contactos {

    //Atributos
    private String nombre;
    private String calificacion;
    private String longitud;
    private String latitud;
    private  String carnet;
    /////////////////////////////////

    /**
     * Constructor
     */
    public  Contactos(){}

    /**
     * get de la calificacion
     * @return la calificacion
     */
    public String getCalificacion() {
        return calificacion;
    }

    /**
     * get del nombre
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * set del nombre
     * @param nombre el nombre a asignar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * get del carnet
     * @return el carnet
     */
    public String getCarnet() {
        return carnet;
    }

    /**
     * set del carnet
     * @param carnet el carnet a asignar
     */
    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    /**
     * set de la calificacion
     * @param calificacion la calificacion a asignar
     */
    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }
}
