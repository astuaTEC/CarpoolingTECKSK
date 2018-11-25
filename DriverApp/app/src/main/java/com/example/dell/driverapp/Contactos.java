package com.example.dell.driverapp;

/**
 * Clase para manejar los contactos de la app
 */
public class Contactos {

    //Atributos
    private String nombre;
    private String calificacion;
    private String longitud;
    private String latitud;
    private  String carnet;

    ////////////////////////////////////////////////////////////////////////

    /**
     * Constructor de la clase
     */
    public Contactos(){}

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
     * @param nombre el nombre que se le quiere poner
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
     * @param carnet el carnet correspondiente
     */
    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    /**
     * set de la calificación
     * @param calificacion la calificacion correspondiente
     */
    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }
}
