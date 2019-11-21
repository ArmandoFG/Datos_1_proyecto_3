/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphviewer.modelo;

/**
 *
 * @author Harold
 */
public class Aristas {
    public Nodo NConect;
    public int Peso;
    
    public Aristas(int peso){
    this.NConect = null;
    this.Peso = peso;
    }
    
    public Object getPeso(){//obtiene nombre del doc
        return this.Peso;
    }
    public void setPeso(int peso){//pone el nombre del doc
        this.Peso = peso;
    }
    
    public void setNodo(Nodo nodo){//pone el nombre del doc
        this.NConect = nodo;
    }
    
    public Nodo getConect() { //devuelve el nodo siguiente
        return this.NConect; 
    }

}
