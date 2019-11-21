/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphviewer.dao;

import java.util.Vector;

/**
 *
 * @author Harold
 */
public class NodoDAO {
    public int NodoID;
    public int Telefono;
    public static int idCount;  
    public Vector<AristasDAO> Aristas;
    
    
    public NodoDAO(int telefono,NodoDAO apuntado, int peso){
    
    this.NodoID = idCount;
    this.Telefono = telefono;
    AristasDAO NArista = new AristasDAO(peso, apuntado);
    this.Aristas.add(NArista);
    idCount ++;
    
    }
    
    public int getID(){//obtiene nombre del doc
        return this.NodoID;
    }
    public void setArista(NodoDAO apuntado, int peso){//pone el nombre del doc
        AristasDAO NArista = new AristasDAO(peso, apuntado);
        this.Aristas.add(NArista);
    }
    
    public int getTelefono() { //devuelve el nodo siguiente
        return this.Telefono; 
    }

}
