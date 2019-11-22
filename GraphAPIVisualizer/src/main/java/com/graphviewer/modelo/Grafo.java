package com.graphviewer.modelo;


import java.util.List;


/**
 *
 * @author arman
 */
public class Grafo {
    int id;   
    public List<Nodo> nodos;
    public List<Aristas> aristas;
    Grafo next;
        
                   
    
   
    public Grafo(int id_grafo){
        
        this.id = id_grafo;
        this.next = null;
        this.nodos = null;
        this.aristas = null;
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

    public List<Aristas> getAristas() {
        return aristas;
    }

    public void setAristas(List<Aristas> aristas) {
        this.aristas = aristas;
    }
    
    public List getNodos() {
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

