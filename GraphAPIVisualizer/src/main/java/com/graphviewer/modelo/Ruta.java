/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphviewer.modelo;

/**
 *
 * @author arman
 */
public class Ruta {
    
      
    String ruta;
    int peso;
    
    
    
    public Ruta(int PESO, String RUTA){
        peso = PESO;
        ruta = RUTA;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    
}
