/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RutaMasCorta;

import java.util.ArrayList;

/**
 * Esta clase se encarga de manejar la clase CaminosMinimos para iniciar el algoritmo de Floyd y llenar una lista con
 * Contenedores. De esta manera se puede obtener los caminos minimos.
 * @author kevin Avevedo
 */
public class Ruteador {

    
    CaminosMinimos ruta = new CaminosMinimos(); // Instancia de la clase CaminosMinimos
    long L = 999999999;  // Se usa para representar si no hay conexion directa de dos vertices en la matriz de pesos
    ArrayList<Contenedor> R; // Se usa para trascribir los datos de la Lista que se genera en el algoritmo Floyd.
    ///////////////////////////////////////////////////////////
    ArrayList<Integer> resultados = new ArrayList<Integer>(); // La lista que va a contener los resultados de la ruta más corta.
    ////////////////////////////////////////////////////////
    
    
    /**
     * Este metodo se va a encargar de correr el algoritmo Floy de la clase CaminosMinimos y guardar las rutas minimas en un ArrayList que pertenece
     * a CaminosMinimos
     * @param matriz La matriz de pesos que va a representar el grafo.
     */
    public void Iniciar_Grafo(long matriz[][]){ 
        
        ruta.algoritmoFloyd(matriz);
        R = ruta.getRutas();
        
        
        
    }
    public static void main(String[] args) {
        long matrizA[][] = {{0,8,999999999,999999999,999999999,999999999},{8,0,999999999,15,999999999,999999999},{20,999999999,0,999999999,12,56},{999999999,999999999,999999999,0,35,999999999},{999999999,999999999,10,999999999,0,27},{999999999,999999999,999999999,999999999,999999999,0}};
        CaminosMinimos ruta = new CaminosMinimos();
        ruta.algoritmoFloyd(matrizA);
        ArrayList<Contenedor> R = ruta.getRutas();
  
        
        System.out.println("El tamaño es "+ Integer.toString(ruta.getRutas().size()));
        for(int r = 0; r < ruta.getRutas().size(); r++){
         
            System.out.println("Para el destino de "+ruta.getRutas().get(r).getID());
            System.out.println("Irse por "+ ruta.getRutas().get(r).getRutita());

           
            System.out.println();
            System.out.println();
            
        }

        
        
        
    }
     /**
     * Este metodo se va a encargar de correr el algoritmo Floy de la clase CaminosMinimos y guardar las rutas minimas en un ArrayList que pertenece
     * a CaminosMinimos.
     * 
     */
    public void Iniciar(){
        long matrizA[][] = {{0,8,999999999,999999999,999999999,999999999},{8,0,999999999,15,999999999,999999999},{20,999999999,0,999999999,12,56},{999999999,999999999,999999999,0,35,999999999},{999999999,999999999,10,999999999,0,27},{999999999,999999999,999999999,999999999,999999999,0}};
        CaminosMinimos ruta = new CaminosMinimos();
        ruta.algoritmoFloyd(matrizA);
        ArrayList<Contenedor> R = ruta.getRutas();
        
    }
    /**
     * Este metodo se va encargar de acceder a la lista que contiene los caminos minimos y pasarlos a una Lista que 
     * va a contener enteros.
     * @param origen El vertice de donde se parte.
     * @param destino El vertice a donde llega la ruta.
     * @return Una lista que contiene los vertices por donde tiene que pasar.
     */
    public ArrayList<Integer> dameLaRuta(int origen, int destino){
        String peticion = Integer.toString(origen) +","+ Integer.toString(destino); 
        for(int i = 0; i < R.size(); i++){
            if(peticion.equals(R.get(i).getID())){
                System.out.println("La ruta mas corta para ir de " +Integer.toString(origen)+ " hasta "+ Integer.toString(destino)+ " es :" + R.get(i).getRutita());
                
                resultados = R.get(i).rut;
                return resultados;    
            }
        }
        return null;   
    }
    
}
