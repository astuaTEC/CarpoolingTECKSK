/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RutaMasCorta;

import java.util.ArrayList;

/**
 * Esta clase funciona como un molde que va a contener informacion nesesaria para manejar las rutas más cortas.
 * Todas las instancias de esta clase van a estar presentes en un ArrayList<Contenedor> para ser enviados por el servidor.
 * @author kevin Avevedo
 */
public class Contenedor {
    
    private String rutita; // Un String que muestra la ruta más corta
    
    public ArrayList<Integer> rut = new ArrayList<Integer>(); // Otra forma de representar las rutas más cortas, pero esta vez por medio de posiciones en una Lista
    
    private String ID; // Un identificador para representar el punto de origen y el punto final de la ruta respectiva.
    

    public void setID(String ID){
        this.ID = ID;
    }
    public String getID(){
        return ID;
    }
    public void setRutita(String rutita){
        this.rutita = rutita;
    }
    public String getRutita(){
        return rutita;
    }
    
}
