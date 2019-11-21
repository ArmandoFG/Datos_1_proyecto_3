/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphviewer.dao;

/**
 *
 * @author Harold
 */
public class AristasDAO {
    public NodoDAO NConect;
    public int Peso;
    
    public AristasDAO(int peso, NodoDAO apuntado){
    this.NConect = apuntado;
    this.Peso = peso;
    }
    
    public Object getPeso(){//obtiene nombre del doc
        return this.Peso;
    }
    public void setPeso(int peso){//pone el nombre del doc
        this.Peso = peso;
    }
    
    public NodoDAO getConect() { //devuelve el nodo siguiente
        return this.NConect; 
    }

}
