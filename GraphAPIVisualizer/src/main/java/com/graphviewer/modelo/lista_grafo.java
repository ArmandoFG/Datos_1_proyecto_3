package com.graphviewer.modelo;


/**
 *
 * @author arman
 */
public class lista_grafo {
    
    Grafo raiz;
    
    public lista_grafo(){
        raiz = null;
    }
    
    
    public void agregar(int id, Nodo Nodo){
     
        Grafo nuevo = new Grafo(id/*, Nodo*/); 
        if (raiz == null){
            raiz = nuevo;
        } 
    }}