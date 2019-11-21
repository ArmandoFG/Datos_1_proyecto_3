/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphviewer.modelo;

import java.util.Vector;

/**
 *
 * @author Harold
 */
public class Nodo {
    public int NodoID;
    public int Telefono;  
    public Vector<Aristas> Aristas;
    public int inDegree;
    public int outDegree;
    
    
    public Nodo(int telefono,int Nodeid){
   
        this.NodoID = Nodeid;
        this.Telefono = telefono;
        this.Aristas = null;
        this.inDegree = 0;
        this.outDegree = 0;
    
    }
    
    public int getID(){//obtiene nombre del doc
        return this.NodoID;
    }
    public void addArista(Aristas NArista){//pone el nombre del doc  
        this.Aristas.add(NArista);
    }

    public Vector<Aristas> getAristas() {
        return Aristas;
    }

    public void setAristas(Vector<Aristas> Aristas) {
        this.Aristas = Aristas;
    }

    public int getInDegree() {
        return inDegree;
    }

    public void setInDegree(int inDegree) {
        this.inDegree = inDegree;
    }

    public int getOutDegree() {
        return outDegree;
    }

    public void setOutDegree(int outDegree) {
        this.outDegree = outDegree;
    }
    
    public int getTelefono() { //devuelve el nodo siguiente
        return this.Telefono; 
    }

}
