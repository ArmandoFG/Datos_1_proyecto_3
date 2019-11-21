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
    //public static int idCount;  
    public Vector<Aristas> Aristas;
    public String nombre;
    
    
    public Nodo(int telefono,String nombre,int Nodeid/*,Vector<Aristas> aristas*/){
    
        this.nombre = nombre;
        this.NodoID = Nodeid;
        this.Telefono = telefono;
        this.Aristas = null;
    
    }
    
    public int getID(){//obtiene nombre del doc
        return this.NodoID;
    }
    public void addArista(Aristas NArista){//pone el nombre del doc  
        this.Aristas.add(NArista);
    }
    
    public int getTelefono() { //devuelve el nodo siguiente
        return this.Telefono; 
    }

}
