/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RutaMasCorta;

import java.util.ArrayList;

/**
 * Esta clase se encarga de proporcionar la ruta más corta de todos los vertices a cualquier vertice del grafo. Para esto utiliza
 * una matriz de pesos y para devolver los resultados nos devuelve una ArrayList<Contenedor> para manejar la informacion.
 * @author kevin Avevedo
 */
public class CaminosMinimos {
    
    private ArrayList<Contenedor> rutas = new ArrayList<Contenedor>();// Lista que va a contener los resultados de los caminos finales mas cortos

    /**
     * Este metodo se encarga de brindar las rutas más cortas de todos los vertices a cualquier vertice del grafo. Para ello debe recibir como parametro
     * una matriz de pesos en donde se indique la distancia que hay entre todos los vertices que forman parte del grafo.
     * @param mAdy Una matriz de pesos que debe indicar las distancias entre todos los nodos del grafo.
     */
    public void algoritmoFloyd(long[][] mAdy){
        // Metodo para determinar todos los caminos Floyd
        int vertices = mAdy.length;
        long matrizAdyacencia [][] = mAdy;
        String caminos [][] = new String[vertices][vertices];
        String caminosAuxiliares [][] = new String[vertices][vertices];
        String caminoRecorrido = "", cadena = "", caminitos = "";
        int i,j,k;
        float temporal1, temporal2, temporal3, temporal4, minimo;// la variable minimo va a ser el camino minimo cada vez que vayamos encontrandolo
        
        // Inicializando las matrices caminos y caminosAuxiliares
        for(i = 0; i < vertices; i++){
            for(j = 0; j < vertices; j++){
                caminos[i][j]= "";
                caminosAuxiliares[i][j]= "";
            }
        }
        for(k = 0; k < vertices; k++){
            for(i = 0; i < vertices; i++){
                for(j = 0; j <vertices ; j++){
                    temporal1 = matrizAdyacencia[i][j];
                    
                    temporal2 = matrizAdyacencia[i][k];
                    
                    temporal3 = matrizAdyacencia[k][j];
                    
                    temporal4 = temporal2 + temporal3;
                    
                    // Encontrando el minimo
                    minimo = Math.min(temporal1,temporal4);
                    if(temporal1 != temporal4){
                        if(minimo == temporal4){
                            caminoRecorrido = "";
                            caminosAuxiliares[i][j] = Integer.toString(k);
                            
                            caminos[i][j] = CaminoRecursivo(i,k,caminosAuxiliares,caminoRecorrido) + (k+1);
                        }
                    }
                    matrizAdyacencia[i][j] = (long)minimo;
                }
            }
            
        }

        
        
        //////////////////////////////////////////////////////////////////////////////
        for(i = 0; i < vertices; i++){
            for(j = 0; j < vertices; j++){
                if(matrizAdyacencia[i][j] != 1000000000){
                    if(i != j){ 
                        if(caminos[i][j].equals("")){
                            Contenedor c = new Contenedor();
                            c.setID(Integer.toString(i+1)+","+Integer.toString(j+1));
                            c.setRutita(Integer.toString(i+1)+","+Integer.toString(j+1));
                            toInt(c.getRutita(), c);
                            rutas.add(c);
                            
                            
                
                        }
                        else{
                            
                            Contenedor c1 = new Contenedor();
                            c1.setID(Integer.toString(i+1)+","+Integer.toString(j+1));  
                            c1.setRutita(Integer.toString(i+1)+","+caminos[i][j]+","+Integer.toString(j+1));
                            toInt(c1.getRutita(),c1);
                            rutas.add(c1);
                            
                        
                            
                            
                        }
                        
                    }
                }
                   
            }
            
        }

        
        
        /*return "La Matriz de caminos más cortos entre los diferentes vertices es : \n"+ cadena+ 
                "\nLos diferentes caminos más cortos entre los vertices son: \n"+ caminitos;*/
        
        
        
        
        
        
        
        
        
    }
    public void toInt(String caminos,Contenedor c){
        for(int r = 0; r < caminos.length(); r++){
            if((r%2) == 0){
                c.rut.add(Integer.parseInt(String.valueOf(caminos.charAt(r))));
            }
        }
    }
    
    
    public String CaminoRecursivo(int i, int k, String [][]caminosAuxiliares, String caminoRecorrido){
        if(caminosAuxiliares[i][k].equals("")){
            return "";
            
        }
        else{
            //Recursividad al Millon
            caminoRecorrido += CaminoRecursivo(i,Integer.parseInt(caminosAuxiliares[i][k].toString()),caminosAuxiliares, caminoRecorrido ) +(Integer.parseInt(caminosAuxiliares[i][k].toString())+ 1)+ ",";
            return caminoRecorrido;
        }
    }
    
    public ArrayList<Contenedor> getRutas(){
        return rutas;
    }
            
    
    
}
