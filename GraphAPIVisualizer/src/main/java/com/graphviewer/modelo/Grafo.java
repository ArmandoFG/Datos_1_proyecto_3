package com.graphviewer.modelo;


import java.util.List;


/**
 *
 * @author arman
 */
public class Grafo {
    int id;   
    public static List<Nodo> nodos;
    public static List<Aristas> aristas;
    Grafo next;
        
                   
    
   
    public Grafo(int id_grafo/*, NodoDAO Nodo*/){
        
        this.id = id_grafo;
        this.next = null;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Nodo getNodo(int index) {
        return nodos.get(index);
    }

    public static List<Aristas> getAristas() {
        return aristas;
    }

    public static void setAristas(List<Aristas> aristas) {
        Grafo.aristas = aristas;
    }
    
    public static List getNodos() {
        return nodos;
    }

    
    public void setNodo(Nodo nodo,int index) {
        this.nodos.set(index, nodo);
    }

    public Grafo getNext() {
        return next;
    }

    public void setNext(Grafo next) {
        this.next = next;
    }
    

  
    

    
     
}

